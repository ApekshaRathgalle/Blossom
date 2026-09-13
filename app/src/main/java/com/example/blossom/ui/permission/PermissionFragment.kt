package com.example.blossom.ui.permission

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.question.QuestionFragment

class PermissionFragment : Fragment() {

    private var waitingForUsagePermission = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_permission,
            container,
            false
        )

        val back = view.findViewById<View>(R.id.backArrow)
        val setupLater = view.findViewById<View>(R.id.setupLater)
        val allowButton = view.findViewById<View>(R.id.allowButton)

        // Back → Onboarding 3
        back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Set Up Later → Question screen
        setupLater.setOnClickListener {
            goToQuestion()
        }

        // Allow → Start real permission process
        allowButton.setOnClickListener {

            if (!hasUsagePermission()) {

                waitingForUsagePermission = true

                val intent =
                    Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)

                startActivity(intent)

            } else {

                requestNotificationPermission()
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        // Only check after returning from Usage Access Settings
        if (waitingForUsagePermission) {

            if (hasUsagePermission()) {

                waitingForUsagePermission = false
                requestNotificationPermission()
            }
        }
    }

    private fun hasUsagePermission(): Boolean {

        val appOps =
            requireContext()
                .getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

        val mode = appOps.checkOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS,
            android.os.Process.myUid(),
            requireContext().packageName
        )

        return mode == AppOpsManager.MODE_ALLOWED
    }

    private fun requestNotificationPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (
                requireContext().checkSelfPermission(
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                requestPermissions(
                    arrayOf(
                        android.Manifest.permission.POST_NOTIFICATIONS
                    ),
                    100
                )

            } else {

                goToQuestion()
            }

        } else {

            goToQuestion()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (requestCode == 100) {

            // Continue whether notification permission
            // was accepted or declined.
            goToQuestion()
        }
    }

    private fun goToQuestion() {

        parentFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                QuestionFragment()
            )
            .addToBackStack(null)
            .commit()
    }
}
package com.example.blossom.ui.onboarding


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R


class OnboardingFragment : Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_onboarding_one,

            container,

            false

        )


        val nextButton = view.findViewById<View>(R.id.nextButton)



        nextButton.setOnClickListener {


            parentFragmentManager.beginTransaction()

                .replace(

                    R.id.container,

                    OnboardingTwoFragment()

                )

                .addToBackStack(null)

                .commit()


        }



        return view

    }


}
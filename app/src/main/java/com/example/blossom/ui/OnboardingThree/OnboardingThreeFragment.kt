package com.example.blossom.ui.onboarding


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.permission.PermissionFragment



class OnboardingThreeFragment : Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_onboarding_three,

            container,

            false

        )


        Log.d("ONBOARDING3", "Screen Loaded")



        val getStarted = view.findViewById<View>(R.id.nextButton)



        if(getStarted == null){

            Log.e(
                "ONBOARDING3",
                "Button NOT FOUND - Check nextButton ID in XML"
            )

        }
        else{

            Log.d(
                "ONBOARDING3",
                "Button Found Successfully"
            )


            getStarted.setOnClickListener {


                Log.d(
                    "ONBOARDING3",
                    "Get Started Clicked"
                )



                parentFragmentManager.beginTransaction()

                    .replace(

                        R.id.container,

                        PermissionFragment()

                    )

                    .addToBackStack("permission")

                    .commit()



                Log.d(
                    "ONBOARDING3",
                    "Navigation Started"
                )


            }


        }



        return view


    }


}
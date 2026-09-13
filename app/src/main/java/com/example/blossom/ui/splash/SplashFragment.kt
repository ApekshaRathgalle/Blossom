package com.example.blossom.ui.splash


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.onboarding.OnboardingFragment



class SplashFragment : Fragment() {



    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {



        val view = inflater.inflate(

            R.layout.fragment_splash,

            container,

            false

        )



        val logo = view.findViewById<View>(R.id.blossomLogo)

        val button = view.findViewById<View>(R.id.getStartedBtn)




        // Logo animation


        logo.alpha = 0f


        logo.animate()

            .alpha(1f)

            .scaleX(1.15f)

            .scaleY(1.15f)

            .setDuration(1200)

            .withEndAction {


                logo.animate()

                    .scaleX(1f)

                    .scaleY(1f)

                    .duration = 500

            }

            .start()





        // Button animation


        button.alpha = 0f

        button.translationY = 80f



        button.animate()

            .alpha(1f)

            .translationY(0f)

            .setDuration(900)

            .setStartDelay(800)

            .start()





        // GET STARTED CLICK


        button.setOnClickListener {



            parentFragmentManager.beginTransaction()

                .replace(

                    R.id.container,

                    OnboardingFragment()

                )

                .addToBackStack(null)

                .commit()



        }



        return view

    }



}
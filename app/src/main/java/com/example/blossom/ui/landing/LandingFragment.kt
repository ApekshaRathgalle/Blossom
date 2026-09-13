package com.example.blossom.ui.landing


import android.os.Bundle
import android.view.*
import android.view.animation.*
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.splash.SplashFragment



class LandingFragment : Fragment() {



    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(
            R.layout.fragment_landing,
            container,
            false
        )



        val logo = view.findViewById<View>(R.id.logoImage)

        val glow1 = view.findViewById<View>(R.id.glow1)

        val glow2 = view.findViewById<View>(R.id.glow2)

        val title = view.findViewById<View>(R.id.appName)

        val tagline = view.findViewById<View>(R.id.tagLine)

        val desc = view.findViewById<View>(R.id.description)




        // Logo animation

        logo.alpha = 0f

        logo.scaleX = 0.5f

        logo.scaleY = 0.5f


        logo.animate()

            .alpha(1f)

            .scaleX(1f)

            .scaleY(1f)

            .setDuration(1200)

            .setInterpolator(OvershootInterpolator())

            .start()




        // Glow animation

        fun pulse(view: View){


            view.animate()

                .scaleX(1.15f)

                .scaleY(1.15f)

                .alpha(0.4f)

                .setDuration(2000)

                .withEndAction{


                    view.animate()

                        .scaleX(1f)

                        .scaleY(1f)

                        .alpha(1f)

                        .setDuration(2000)

                        .withEndAction{

                            pulse(view)

                        }

                        .start()

                }

                .start()

        }


        pulse(glow1)

        pulse(glow2)





        // Text animation


        title.alpha=0f

        tagline.alpha=0f

        desc.alpha=0f



        title.translationY=40f

        tagline.translationY=30f

        desc.translationY=20f




        title.animate()

            .alpha(1f)

            .translationY(0f)

            .setDuration(700)

            .setStartDelay(700)

            .start()




        tagline.animate()

            .alpha(1f)

            .translationY(0f)

            .setDuration(700)

            .setStartDelay(900)

            .start()




        desc.animate()

            .alpha(1f)

            .translationY(0f)

            .setDuration(700)

            .setStartDelay(1100)

            .start()





        // OPEN SPLASH AFTER 30 SECONDS


        view.postDelayed({


            parentFragmentManager.beginTransaction()

                .replace(
                    R.id.container,
                    SplashFragment()
                )

                .commit()



        },5000)



        return view

    }


}
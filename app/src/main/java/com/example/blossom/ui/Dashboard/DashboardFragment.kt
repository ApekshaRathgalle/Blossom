package com.example.blossom.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.blossom.R
import com.example.blossom.data.UsageDataManager
import com.example.blossom.data.SleepDataManager
import com.example.blossom.ui.nightbloom.NightBloomFragment



class DashboardFragment : Fragment() {



    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {



        val view = inflater.inflate(

            R.layout.fragment_dashboard,

            container,

            false

        )





        val usageManager =

            UsageDataManager(

                requireContext()

            )





        val sleepManager =

            SleepDataManager(

                requireContext()

            )








        // SCREEN TIME


        val screenTime =

            view.findViewById<TextView>(

                R.id.screenTime

            )



        screenTime.text =

            "Screen Time\n" +
                    usageManager.formatTime(
                        usageManager.getTodayScreenTime()
                    )










        // APP OPENINGS


        val appOpenings =

            view.findViewById<TextView>(

                R.id.appOpenings

            )



        appOpenings.text =

            "App Openings\n" +
                    usageManager.getAppOpeningCount()










        // LATE NIGHT


        val lateNight =

            view.findViewById<TextView>(

                R.id.lateNight

            )



        lateNight.text =

            "Late Night\n" +
                    sleepManager.formatTime(

                        sleepManager.getLateNightUsage()

                    )










        // BEDTIME DELAY


        val bedtimeDelay =

            view.findViewById<TextView>(

                R.id.bedtimeDelay

            )



        bedtimeDelay.text =

            "Bedtime Delay\n" +
                    sleepManager.formatTime(

                        sleepManager.getBedtimeDelay()

                    )










        // OPEN NIGHT BLOOM SCREEN


        val bedtimeCard =

            view.findViewById<View>(

                R.id.bedtimeCard

            )



        bedtimeCard.setOnClickListener {



            parentFragmentManager

                .beginTransaction()

                .replace(

                    R.id.navContainer,

                    NightBloomFragment()

                )

                .addToBackStack(null)

                .commit()



        }









        // MOST USED APPS


        val mostUsed =

            view.findViewById<TextView>(

                R.id.mostUsedApps

            )



        val apps =

            usageManager.getMostUsedApps()





        val builder =

            StringBuilder()





        for(app in apps){



            try {



                val name =

                    requireContext()

                        .packageManager

                        .getApplicationLabel(

                            requireContext()

                                .packageManager

                                .getApplicationInfo(

                                    app.packageName,

                                    0

                                )

                        )



                builder.append(

                    "• $name\n"

                )



            }


            catch(e:Exception){



                builder.append(

                    "• ${app.packageName}\n"

                )


            }



        }






        if(builder.isEmpty()){



            mostUsed.text =

                "No usage data"



        }

        else{



            mostUsed.text =

                builder.toString()



        }









        // WELLNESS SCORE


        val score =

            view.findViewById<TextView>(

                R.id.wellnessScore

            )





        score.text =

            calculateScore(

                usageManager.getTodayScreenTime()

            ).toString()






        return view



    }












    private fun calculateScore(

        time:Long

    ):Int {



        val minutes =

            time / 1000 / 60





        var score = 100





        if(minutes > 300){


            score -= 25


        }

        else if(minutes > 180){


            score -= 10


        }






        if(score < 0){


            score = 0


        }



        return score



    }



}
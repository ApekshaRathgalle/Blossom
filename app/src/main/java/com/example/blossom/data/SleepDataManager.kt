package com.example.blossom.data


import android.content.Context



class SleepDataManager(

    private val context: Context

) {



    // =========================
    // Late Night Usage
    // =========================


    fun getLateNightUsage(): Long {


        /*
        Temporary logic.

        Later we will replace this with
        UsageEventsManager to detect
        actual usage between 11PM - 5AM.
        */


        return 56 * 60 * 1000L


    }






    // =========================
    // Bedtime Delay
    // =========================


    fun getBedtimeDelay(): Long {


        /*
        Temporary logic.

        Target bedtime:
        11:00 PM

        Later this will calculate
        actual delay from usage events.
        */


        return 35 * 60 * 1000L


    }








    // =========================
    // Format Milliseconds
    // =========================


    fun formatTime(

        milliseconds: Long

    ): String {



        val totalMinutes =

            milliseconds /
                    1000 /
                    60



        val hours =

            totalMinutes /
                    60



        val minutes =

            totalMinutes %
                    60





        return if(hours > 0){


            "${hours}h ${minutes}m"


        }
        else{


            "${minutes}m"


        }



    }



}
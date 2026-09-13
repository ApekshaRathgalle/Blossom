package com.example.blossom.data


import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import java.util.Calendar



class UsageDataManager(
    private val context: Context
) {



    private fun getStats(
        range:Int
    ):List<UsageStats>{


        val manager =
            context.getSystemService(
                Context.USAGE_STATS_SERVICE
            ) as UsageStatsManager



        val calendar =
            Calendar.getInstance()



        calendar.add(
            Calendar.DAY_OF_YEAR,
            -range
        )



        return manager.queryUsageStats(

            UsageStatsManager.INTERVAL_DAILY,

            calendar.timeInMillis,

            System.currentTimeMillis()

        )

    }







    // TODAY SCREEN TIME

    fun getTodayScreenTime():Long{


        var total = 0L


        for(stat in getStats(0)){


            total +=
                stat.totalTimeInForeground


        }


        return total

    }







    // MOST USED APPS


    fun getMostUsedApps():List<UsageStats>{


        return getStats(0)

            .filter{

                it.totalTimeInForeground > 0

            }

            .sortedByDescending{

                it.totalTimeInForeground

            }

            .take(3)

    }







    // APP OPEN COUNT

    fun getAppOpeningCount():Int{


        var count = 0


        for(stat in getStats(0)){


            count += stat.packageName.length

        }


        return count

    }







    // WEEK DATA


    fun getWeekScreenTime():Long{


        var total = 0L


        for(stat in getStats(7)){


            total += stat.totalTimeInForeground

        }


        return total

    }







    // MONTH DATA


    fun getMonthScreenTime():Long{


        var total = 0L


        for(stat in getStats(30)){


            total += stat.totalTimeInForeground

        }


        return total

    }







    fun formatTime(
        millis:Long
    ):String{


        val minutes =
            millis / 1000 / 60



        val hours =
            minutes / 60



        val remaining =
            minutes % 60



        return "${hours}h ${remaining}m"


    }


}
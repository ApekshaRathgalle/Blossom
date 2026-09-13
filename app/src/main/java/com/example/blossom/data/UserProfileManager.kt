package com.example.blossom.data


import android.content.Context
import android.content.SharedPreferences



class UserProfileManager(context: Context) {


    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            "blossom_profile",
            Context.MODE_PRIVATE
        )



    // NAME

    fun saveName(name:String){

        prefs.edit()
            .putString(
                "user_name",
                name
            )
            .apply()

    }



    fun getName():String{

        return prefs.getString(
            "user_name",
            "Maya"
        )!!

    }





    // PROFILE IMAGE

    fun saveImage(uri:String){

        prefs.edit()
            .putString(
                "profile_image",
                uri
            )
            .apply()

    }



    fun getImage():String?{


        return prefs.getString(
            "profile_image",
            null
        )

    }







    // SCREEN GOAL


    fun saveScreenGoal(value:String){

        prefs.edit()
            .putString(
                "screen_goal",
                value
            )
            .apply()

    }



    fun getScreenGoal():String{


        return prefs.getString(
            "screen_goal",
            "4 hours"
        )!!

    }







    // BEDTIME


    fun saveBedtime(value:String){


        prefs.edit()
            .putString(
                "bedtime",
                value
            )
            .apply()

    }




    fun getBedtime():String{


        return prefs.getString(
            "bedtime",
            "11:00 PM"
        )!!

    }







    // SELECTED APPS


    fun saveApps(value:String){


        prefs.edit()
            .putString(
                "apps",
                value
            )
            .apply()

    }




    fun getApps():String{


        return prefs.getString(
            "apps",
            "5 monitored"
        )!!

    }






    // NOTIFICATIONS


    fun saveNotifications(enabled:Boolean){


        prefs.edit()
            .putBoolean(
                "notifications",
                enabled
            )
            .apply()

    }



    fun getNotifications():Boolean{


        return prefs.getBoolean(
            "notifications",
            true
        )

    }




}
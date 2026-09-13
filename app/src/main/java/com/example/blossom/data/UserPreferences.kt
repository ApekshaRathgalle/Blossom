package com.example.blossom.data

import android.content.Context


class UserPreferences(context: Context) {


    private val prefs =
        context.getSharedPreferences(
            "blossom_user",
            Context.MODE_PRIVATE
        )


    fun saveGoal(goal:String){

        prefs.edit()
            .putString("goal",goal)
            .apply()

    }


    fun getGoal():String{

        return prefs.getString(
            "goal",
            ""
        ) ?: ""

    }

}
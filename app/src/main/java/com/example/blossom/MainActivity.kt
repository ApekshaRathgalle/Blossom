package com.example.blossom


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blossom.ui.landing.LandingFragment


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        if(savedInstanceState == null){


            supportFragmentManager.beginTransaction()

                .replace(
                    R.id.container,
                    LandingFragment()
                )

                .commit()

        }

    }

}
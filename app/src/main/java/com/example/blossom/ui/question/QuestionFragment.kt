package com.example.blossom.ui.question


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import com.example.blossom.R
import com.example.blossom.ui.navigation.BottomNavigationFragment



class QuestionFragment : Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_question,

            container,

            false

        )



        val continueButton =

            view.findViewById<View>(

                R.id.continueButton

            )





        continueButton.setOnClickListener {



            Log.d(
                "QUESTION",
                "Continue clicked"
            )



            parentFragmentManager

                .beginTransaction()

                .replace(

                    R.id.container,

                    BottomNavigationFragment()

                )

                .addToBackStack(null)

                .commit()



        }





        return view

    }


}
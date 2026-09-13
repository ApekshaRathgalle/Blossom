package com.example.blossom.ui.nightbloom


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.winddown.WindDownFragment
import android.widget.Button


class NightBloomFragment : Fragment(){


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_nightbloom,

            container,

            false

        )



        val back =

            view.findViewById<View>(

                R.id.backButton

            )


        back.setOnClickListener{


            parentFragmentManager.popBackStack()


        }
        val startRoutine =
            view.findViewById<Button>(
                R.id.startRoutine
            )


        startRoutine.setOnClickListener {


            parentFragmentManager

                .beginTransaction()

                .replace(
                    R.id.navContainer,
                    WindDownFragment()
                )

                .addToBackStack("nightbloom")

                .commit()


        }


        return view

    }


}
package com.example.blossom.ui.winddown


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.nightbloom.NightBloomFragment



class WindDownFragment : Fragment(){



    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {



        val view = inflater.inflate(

            R.layout.fragment_wind_down,

            container,

            false

        )



        val back =

            view.findViewById<View>(

                R.id.backButton

            )


        back.setOnClickListener{


            parentFragmentManager

                .popBackStack()


        }



        return view

    }


}
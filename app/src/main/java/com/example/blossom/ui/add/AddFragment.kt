package com.example.blossom.ui.add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.blossom.R



class AddFragment : Fragment(){


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        return inflater.inflate(

            R.layout.fragment_add,

            container,

            false

        )


    }


}
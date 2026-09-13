package com.example.blossom.ui.habits


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.createhabit.CreateHabitFragment


class HabitsFragment : Fragment(){


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_habits,

            container,

            false

        )



        val all =
            view.findViewById<Button>(R.id.allButton)


        val active =
            view.findViewById<Button>(R.id.activeButton)


        val completed =
            view.findViewById<Button>(R.id.completedButton)



        val status =
            view.findViewById<TextView>(R.id.statusText)



        all.setOnClickListener {

            status.text =
                "Showing All Habits"

        }



        active.setOnClickListener {

            status.text =
                "Showing Active Habits"

        }



        completed.setOnClickListener {

            status.text =
                "Showing Completed Habits"

        }



        val addHabit =
            view.findViewById<View>(R.id.addHabitButton)
                .setOnClickListener {


                    parentFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.navContainer,
                            CreateHabitFragment()
                        )
                        .addToBackStack(null)
                        .commit()


                }



        return view

    }

}
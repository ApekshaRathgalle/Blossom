package com.example.blossom.ui.createhabit


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.ui.habits.HabitsFragment


class CreateHabitFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view = inflater.inflate(
            R.layout.fragment_create_habit,
            container,
            false
        )



        // BACK BUTTON

        view.findViewById<TextView>(R.id.backButton)
            .setOnClickListener {

                parentFragmentManager.popBackStack()

            }





        // CREATE HABIT BUTTON


        view.findViewById<Button>(R.id.createHabit)
            .setOnClickListener {


                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.navContainer,
                        HabitsFragment()
                    )
                    .addToBackStack(null)
                    .commit()


            }





        // CANCEL BUTTON


        view.findViewById<Button>(R.id.cancelHabit)
            .setOnClickListener {


                parentFragmentManager.popBackStack()


            }





        // DAILY / WEEKLY

        val daily =
            view.findViewById<TextView>(
                R.id.dailyButton
            )


        val weekly =
            view.findViewById<TextView>(
                R.id.weeklyButton
            )



        daily.setOnClickListener {


            daily.setBackgroundResource(
                R.drawable.button_pink
            )


            weekly.setBackgroundResource(
                R.drawable.input_background
            )


        }




        weekly.setOnClickListener {


            weekly.setBackgroundResource(
                R.drawable.button_pink
            )


            daily.setBackgroundResource(
                R.drawable.input_background
            )


        }





        // ICON SELECTION

        val icons = listOf(

            R.id.iconSun,
            R.id.iconMoon,
            R.id.iconLeaf,
            R.id.iconBook,
            R.id.iconWalk,
            R.id.iconPhone

        )


        for(id in icons){


            view.findViewById<View>(id)
                .setOnClickListener {


                    it.setBackgroundResource(
                        R.drawable.selected_icon_circle
                    )


                }


        }




        return view

    }


}
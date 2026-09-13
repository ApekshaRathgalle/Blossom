package com.example.blossom.ui.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.blossom.R

import com.example.blossom.ui.dashboard.DashboardFragment
import com.example.blossom.ui.profile.ProfileFragment
import com.example.blossom.ui.Insights.InsightsFragment
import com.example.blossom.ui.createhabit.CreateHabitFragment
import com.example.blossom.ui.habits.HabitsFragment


class BottomNavigationFragment : Fragment() {


    override fun onCreateView(

        inflater: LayoutInflater,

        container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View {


        val view = inflater.inflate(

            R.layout.fragment_bottom_navigation,

            container,

            false

        )



        // Default screen

        loadFragment(
            DashboardFragment()
        )





        // Home Button

        view.findViewById<View>(R.id.homeButton)

            .setOnClickListener {

                loadFragment(
                    DashboardFragment()
                )

            }


        view.findViewById<View>(R.id.insightsButton)

            .setOnClickListener{


                loadFragment(

                    InsightsFragment()

                )


            }



        // Add Button

        view.findViewById<View>(R.id.addButton)
            .setOnClickListener{


                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.navContainer,
                        CreateHabitFragment()
                    )
                    .addToBackStack(null)
                    .commit()


            }






        view.findViewById<View>(R.id.focusButton)

            .setOnClickListener{


                loadFragment(

                    HabitsFragment()

                )


            }







        view.findViewById<View>(R.id.profileButton)
            .setOnClickListener{


                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.navContainer,
                        ProfileFragment()
                    )
                    .addToBackStack(null)
                    .commit()


            }



        return view

    }





    private fun loadFragment(fragment: Fragment) {


        childFragmentManager

            .beginTransaction()

            .replace(

                R.id.navContainer,

                fragment

            )

            .commit()


    }


}
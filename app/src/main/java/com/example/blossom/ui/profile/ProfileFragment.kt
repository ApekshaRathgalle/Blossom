package com.example.blossom.ui.profile


import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.blossom.R
import com.example.blossom.data.UserProfileManager



class ProfileFragment:Fragment(){


    private lateinit var manager:UserProfileManager

    private lateinit var profileImage:ImageView

    private val PICK_IMAGE = 100



    override fun onCreateView(
        inflater:LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ):View{


        val view =
            inflater.inflate(
                R.layout.fragment_profile,
                container,
                false
            )



        manager =
            UserProfileManager(
                requireContext()
            )




        val name =
            view.findViewById<TextView>(
                R.id.userName
            )


        profileImage =
            view.findViewById(
                R.id.profileImage
            )





        // LOAD DATA


        name.text =
            manager.getName()



        loadProfileImage()



        view.findViewById<TextView>(
            R.id.screenGoal
        ).text =
            "▣  Daily Screen Goal        ${manager.getScreenGoal()}  ›"




        view.findViewById<TextView>(
            R.id.bedtime
        ).text =
            "☾  Planned Bedtime        ${manager.getBedtime()}  ›"




        view.findViewById<TextView>(
            R.id.apps
        ).text =
            "▦  Selected Apps             ${manager.getApps()} ›"








        // CHANGE NAME


        name.setOnClickListener{


            val input =
                EditText(requireContext())


            input.setText(
                name.text
            )


            AlertDialog.Builder(requireContext())

                .setTitle("Edit Name")

                .setView(input)

                .setPositiveButton("Save"){_,_->


                    manager.saveName(
                        input.text.toString()
                    )


                    name.text =
                        input.text.toString()

                }

                .setNegativeButton(
                    "Cancel",
                    null
                )

                .show()


        }





        // IMAGE PICKER


        profileImage.setOnClickListener{


            val intent =
                Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                )


            startActivityForResult(
                intent,
                PICK_IMAGE
            )

        }






        return view

    }







    override fun onActivityResult(
        requestCode:Int,
        resultCode:Int,
        data:Intent?
    ){


        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )



        if(
            requestCode==PICK_IMAGE &&
            resultCode==Activity.RESULT_OK
        ){


            val uri =
                data?.data


            if(uri!=null){


                profileImage.setImageURI(uri)


                manager.saveImage(
                    uri.toString()
                )


            }


        }


    }







    private fun loadProfileImage(){


        val saved =
            manager.getImage()



        if(saved!=null){


            profileImage.setImageURI(
                Uri.parse(saved)
            )

        }


    }



}
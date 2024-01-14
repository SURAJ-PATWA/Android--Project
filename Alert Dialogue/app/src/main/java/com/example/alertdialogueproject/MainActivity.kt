package com.example.alertdialogueproject

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialogueproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btn1.setOnClickListener {
            val builder1=AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close the App")
            builder1.setIcon(R.drawable.baseline_arrow_circle_right_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // if  click yes what action should be performed
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when No is Clicked

            })
            builder1.show()

        }

        binding.btn2.setOnClickListener {
            val options= arrayOf("Simple Rice","Fry Rice","Jira Rice")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is Your Favorite Rice?")
            builder2.setSingleChoiceItems(options,-1,DialogInterface.OnClickListener { dialog, which ->
                //What action should be Performrd when User Click on any options
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // if  click yes what action should be performed

            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when No is Clicked

            })
            builder2.show()

        }
        binding.btn3.setOnClickListener {
            val options= arrayOf("Simple Rice","Fry Rice","Jira Rice")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is Your Favorite Rice?")
            builder2.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->


                //What action should be Performrd when User Click on any options
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // if  click yes what action should be performed

            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when No is Clicked

            })
            builder2.show()

        }


    }
}
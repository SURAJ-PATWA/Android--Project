package com.example.assignment2project

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.assignment2project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn1.setOnClickListener {
            val options= arrayOf("CSE","ECE","EEE")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is Your Branch ")
            builder2.setSingleChoiceItems(options,-1,DialogInterface.OnClickListener { dialog, which ->
                //What action should be Performrd when User Click on any options
                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // if  click yes what action should be performed

            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //what action should be performed when No is Clicked

            })
            builder2.show()

        }
        binding.btn2.setOnClickListener {
            val options= arrayOf("FRONTEND","BACKEND","FULL STACK")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is Your Development core")
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
            val options= arrayOf("C++","Java","Python")
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("What is Your Favourite Programming Language")
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

        binding.btn4.setOnClickListener {
       val builder4= AlertDialog.Builder(this)
        builder4.setTitle("Are you Sure?")
        builder4.setMessage("Do you want to close the App")
        builder4.setIcon(R.drawable.baseline_arrow_circle_right_24)
        builder4.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            // if  click yes what action should be performed
            finish()
        })
        builder4.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            //what action should be performed when No is Clicked

        })
        builder4.show()

    }


    }}

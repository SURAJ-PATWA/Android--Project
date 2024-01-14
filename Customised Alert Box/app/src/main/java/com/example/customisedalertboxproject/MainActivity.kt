package com.example.customisedalertboxproject

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var dialog:Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myButton=findViewById<Button>(R.id.btnClick)
        dialog=Dialog(this)
          dialog.setContentView(R.layout.custom_dialogue)
        dialog.window ?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        //creating variable for the custom_dialogue.xml design
        var buttonGood=dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeedback=dialog.findViewById<Button>(R.id.btnFeedback)

        buttonGood.setOnClickListener {
            dialog.dismiss()
        }
        buttonFeedback.setOnClickListener {
  Toast.makeText(this,"Thank You",Toast.LENGTH_SHORT).show()
        }

        myButton.setOnClickListener {
            dialog.show()
        }



    }
}
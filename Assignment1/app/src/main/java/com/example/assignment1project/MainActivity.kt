package com.example.assignment1project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondIntent =findViewById<Button>(R.id.button)


        secondIntent.setOnClickListener {
            val intent= Intent(applicationContext,screen2::class.java)
            startActivity(intent)

        }
    }
}
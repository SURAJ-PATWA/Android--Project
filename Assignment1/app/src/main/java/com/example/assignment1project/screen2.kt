package com.example.assignment1project

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.cardview.widget.CardView

class screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val appButton=findViewById<CardView>(R.id.app1)
        val webButton=findViewById<CardView>(R.id.web1)
        val iosButton=findViewById<CardView>(R.id.ios1)
        val machineButton=findViewById<CardView>(R.id.machine1)
        val blockButton=findViewById<CardView>(R.id.block1)
        val cloudButton=findViewById<CardView>(R.id.cloud1)


        appButton.setOnClickListener {
            val intent=Intent(applicationContext,AppPage::class.java)
           startActivity(intent)

        }
        webButton.setOnClickListener {
            val intent=Intent(applicationContext,WebPage::class.java)
            startActivity(intent)

        }
        iosButton.setOnClickListener {
            val intent=Intent(applicationContext,IosPage::class.java)
            startActivity(intent)

        }
        machineButton.setOnClickListener {
            val intent=Intent(applicationContext,MachinePage::class.java)
            startActivity(intent)

        }
        blockButton.setOnClickListener {
            val intent=Intent(applicationContext,BlockPage::class.java)
            startActivity(intent)

        }
        cloudButton.setOnClickListener {
            val intent=Intent(applicationContext,CloudPage::class.java)
            startActivity(intent)

        }

    }
}
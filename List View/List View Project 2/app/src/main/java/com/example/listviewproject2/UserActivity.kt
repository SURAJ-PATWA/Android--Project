package com.example.listviewproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        val name=intent.getStringExtra("name")   // acess name val all data
        val phonenumber =intent.getStringExtra("phone")
//        val imageId=intent.getIntExtra("imageId",R.drawable.pic1)
        val imageId =intent.getIntExtra("imageId",R.drawable.pic1)

        //access id in text button
        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val image=findViewById<CircleImageView>(R.id.profile_image)


        nameTv.text=name
        phoneTv.text=phonenumber
        image.setImageResource(imageId)



    }
}
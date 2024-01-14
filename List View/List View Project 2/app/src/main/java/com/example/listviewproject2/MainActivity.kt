package com.example.listviewproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

     lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayOf("Suraj ","Abdul kalam","Akshay","Rashimka ","Patwa")
        var lastMsg = arrayOf("This side is Suraj","This side is Dr. Kalam","This side is Akshay","This side Rasmika Mandana ","This side is Self Patwa")
        val lastMsgTime= arrayOf("6:25 Am","7:30 Pm","5:00 Pm","6:25 Am","7:30 Am")
        val phoneNumber= arrayOf("77777777","888888888","55868688","868686866","8556665868")
        val imgId= intArrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5)

        userArrayList = ArrayList()

        for(eachIndex in name.indices) {
            val user = User(
                name[eachIndex],
                lastMsg[eachIndex],
                lastMsgTime[eachIndex],
                phoneNumber[eachIndex],
                imgId[eachIndex]
            )
            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable=true
        listView.adapter=MyAdapter(this,userArrayList)


        listView.setOnItemClickListener { parent, view, position, id ->
            //open a new activity
            val userName=name[position]
            val userPhone=phoneNumber[position]
            val imageId = imgId[position]

            val i=Intent(this,UserActivity::class.java)

              i.putExtra("name",userName)
            i.putExtra("phone",userPhone)
            i.putExtra("imageid",imageId)
            startActivity(i)

        }


    }
}
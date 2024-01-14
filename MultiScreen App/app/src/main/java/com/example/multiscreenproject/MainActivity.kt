package com.example.multiscreenproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    // create a static keyword

    companion object{
        const val KEY="com.example.MultiScreen.MainActivity.KEY"   // yaha koi random package ho sakta haa
    }
    //creating key
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // no need findviewbyId<>
        val btnOrder=findViewById<Button>(R.id.btnOrder)
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val et3=findViewById<EditText>(R.id.et3)
        val et4=findViewById<EditText>(R.id.et4)

        btnOrder.setOnClickListener {
 val OrdersPlaced = "1"+ et1.text.toString() + "\n" +
                "2"+et2.text.toString() + "\n" +
                "3"+et3.text.toString() + "\n" +
                "4"+et4.text.toString()

            intent= Intent(this,Order::class.java)
            intent.putExtra(KEY,OrdersPlaced)
            startActivity(intent)
        }
    }
}
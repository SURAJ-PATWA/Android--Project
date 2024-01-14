package com.example.signuppage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    // for db
    lateinit var database:DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signButton=findViewById<Button>(R.id.btnSignUp)
        val etName=findViewById<TextInputEditText>(R.id.etName)
        val etMail=findViewById<TextInputEditText>(R.id.etMail)
        val userId=findViewById<TextInputEditText>(R.id.etUserName)
        val userPassword=findViewById<TextInputEditText>(R.id.etPassword)


        signButton.setOnClickListener {
            val name=etName.text.toString()
            val mail=etMail.text.toString()
            val uniqueId=userId.text.toString()
            val password=userPassword.text.toString()

            val user=User(name,mail,password,uniqueId) // create a obj

            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
               etName.text?.clear()  //  so that after sign up it remove the data for screen
                etMail.text?.clear()
              userId.text?.clear()
                userPassword.text?.clear()
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
            }
        }



        val signIntext=findViewById<TextView>(R.id.tvSignIN)
        signIntext.setOnClickListener {
            val openSignInActivity=Intent(this,SignInActivity::class.java)
            startActivity(openSignInActivity)
        }


    }
}
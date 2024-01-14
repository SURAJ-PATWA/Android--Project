package com.example.signuppage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.signuppage.R.*
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

   private lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1="com.example.SignUp.SignInActivity.mail"
        const val KEY2="com.example.SignUp.SignInActivity.name"
        const val KEY3="com.example.SignUp.SignInActivity.id"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_sign_in)

        val signInbutton=findViewById<Button>(id.btnSignIn)
        val userName=findViewById<TextInputEditText>(id.userNameEditText)

        signInbutton.setOnClickListener {
           val uniqueId=userName.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }
            else{
                Toast.makeText(this,"Please enter user Name",Toast.LENGTH_SHORT).show()
            }

        }


    }

  private  fun readData(uniqueId:String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            // if user exist or not
            if(it.exists()){
                //welcome user in your app, with intent and also pass
                val email=it.child("email").value
                val name=it.child("name").value
                val userId=it.child("uniqueId").value

                val intentWelcome= Intent(this,WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1,email.toString())
                intentWelcome.putExtra(KEY2,name.toString())
                intentWelcome.putExtra(KEY3,userId.toString())
                startActivity(intentWelcome)

            }
            else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this,"Failed,Error in DB ",Toast.LENGTH_SHORT).show()
        }
    }
}
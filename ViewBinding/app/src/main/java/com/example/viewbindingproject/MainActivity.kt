package com.example.viewbindingproject

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbindingproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.checkBox.isChecked){
                //open a new screnn
            }
            else{
                binding.checkBox.buttonTintList= ColorStateList.valueOf(Color.RED)
                Toast.makeText(this,"Please click the T&C",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.apiproject

import MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)

        setContentView( R.layout.activity_main)
        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        //  get data

        val retrofitData  =retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is success, then use the data of api and show in your app
                var responseBody =response.body()

                val productList =responseBody ?.products!!   // mean prooducts empty na hoo

                val collectDataInSB =StringBuilder()

                for(myData in productList){
                    collectDataInSB.append(myData.title +"  ")
                }

                val tv=findViewById<TextView>(R.id.textView)
                tv.text=collectDataInSB
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // if aoi cll fails

                Log.d("Main Activity ","onFailure: "+ t.message)
            }
        })
    }
}
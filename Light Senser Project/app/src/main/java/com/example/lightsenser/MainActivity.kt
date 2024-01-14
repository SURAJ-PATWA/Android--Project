package com.example.lightsenser

import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout.TabGravity
import java.io.IOException

class MainActivity : AppCompatActivity(),SensorEventListener {

    var sensor:Sensor?=null
    var sensorManager:SensorManager?=null
    lateinit var image:ImageView
    lateinit var background:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image=findViewById(R.id.displayImage)
        background=findViewById(R.id.backgroundMain)
       image.visibility=View.INVISIBLE                             // initially background invisible kar de

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)





    }
    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        //most imp function
            try {
                if (event != null) {
                    Log.d(TAG,"onSensorChanged: "+event.values[0])
                }

                if(event!!.values[0]<30){ // if event not null auto
                    //light is dim
                    image.visibility=View.INVISIBLE
                    background.setBackgroundColor(resources.getColor(R.color.black))
                }
                else{
                    //show tourchif light intensity is high
                    image.visibility=View.VISIBLE //image show hoga
                    background.setBackgroundColor(resources.getColor(R.color.yello))
                }


            }catch (e:IOException){
                Log.d(TAG,"onSensorChanged: + ${e.message}")
            }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}
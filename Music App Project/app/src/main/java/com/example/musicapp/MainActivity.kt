package com.example.musicapp

import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer :MediaPlayer
    var totalTime:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer= MediaPlayer.create(this,R.raw.music)
        mediaPlayer.setVolume(1f,1f)
        totalTime=mediaPlayer.duration

        val btnplay=findViewById<ImageView>(R.id.play)
        val btnPause = findViewById<ImageView>(R.id.pause)
        val btnStop=findViewById<ImageView>(R.id.stop)
        val  seekBarMusic=findViewById<SeekBar>(R.id.seekBar)

        btnplay.setOnClickListener {
            mediaPlayer.start()
        }
        btnPause.setOnClickListener {
            mediaPlayer.pause()
        }
        btnStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        // when user the time stamp ofmusic,reflect that chenge
        seekBarMusic.max=totalTime
        seekBarMusic.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               if(fromUser){
                   mediaPlayer.seekTo(progress)
               }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        //chenge the seekbar position based onthe music
        val handler =Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                seekBarMusic.progress=mediaPlayer.currentPosition
                handler.postDelayed(this,1000)
            }

        },0)

    }
}
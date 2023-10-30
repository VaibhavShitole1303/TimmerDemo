package com.example.myapplicationdemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        var time:String?=null
        var long:Long?=null
        var added:Boolean?= false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv= findViewById<TextView>(R.id.tv)
        val edt =findViewById<EditText>(R.id.edt)
        val btn = findViewById<Button>(R.id.btn)
       time="25"
       long= time!!.toInt()*60* 1000.toLong()
        Toast.makeText(this,long.toString(), Toast.LENGTH_LONG).show()
        btn.setOnClickListener {
            time= (Integer. parseInt(time!!) + 20).toString()
            long= time!!.toInt()*60* 1000.toLong()
            added=true
//                  Integer. parseInt(edt.text.toString())
            Toast.makeText(this,time, Toast.LENGTH_LONG).show()
            Toast.makeText(this,long.toString(), Toast.LENGTH_LONG).show()
        }

        if (added==true){
//            CountDownTimer(long!!, 1000)
        }

        object : CountDownTimer(long!!, 1000) {

            // Callback function, fired on regular interval
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {

//                tv.text = "seconds remaining: " + millisUntilFinished / 1000
                val secs =  millisUntilFinished / 1000
                val formatted = "${(secs / 60).toString().padStart(2, '0')} min : ${(secs % 60).toString().padStart(2, '0')} sec"
                tv.text=formatted
            }


            // Callback function, fired
            // when the time is up
            override fun onFinish() {
               tv.setText("done!")
            }
        }.start()
//        val minutes = 42
//        val millis = (minutes * 60 * 1000).toLong()


    }

}
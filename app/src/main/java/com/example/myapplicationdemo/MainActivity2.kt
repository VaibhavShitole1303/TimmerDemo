package com.example.myapplicationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MainActivity2 : AppCompatActivity() {
    var timer: Timer?=null
    var time:String?=null
    var long:Long?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val edt =findViewById<EditText>(R.id.edt)
        val btn = findViewById<Button>(R.id.btn)
        time="25"
        long= time!!.toInt()*60* 1000.toLong()

        startTimer(long!!)

        btn.setOnClickListener {
            time= (Integer. parseInt(time!!) + Integer. parseInt(edt.text.toString())).toString()
            long= time!!.toInt()*60* 1000.toLong()
            updateTimer(long!!)
//            added=true
//                  Integer. parseInt(edt.text.toString())
            Toast.makeText(this,"Added time::"+edt.text.toString(), Toast.LENGTH_LONG).show()
//            Toast.makeText(this,long.toString(), Toast.LENGTH_LONG).show()
        }



    }
    //Call this method to start timer on activity start
    fun startTimer(x:Long){
        timer = Timer(x);
        timer?.start()
    }
    //Call this method to update the timer
    fun updateTimer(up:Long){
        if(timer!=null) {
            val miliis = timer?.millisUntilFinished?.plus(up)
            //Here you need to maintain single instance for previous
            timer?.cancel()
            timer = miliis?.let { Timer(long!!) };
            timer?.start()
        }else{
            startTimer(long!!)
        }
    }
    inner class Timer(miliis:Long) : CountDownTimer(miliis,1000){
        var millisUntilFinished:Long = 0
        val tv= findViewById<TextView>(R.id.tv)
        override fun onFinish() {
            tv.text = "done!"

        }

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
            val secs =  millisUntilFinished / 1000

            val formatted = "${(secs / 60).toString().padStart(2, '0')} min : ${(secs % 60).toString().padStart(2, '0')} sec"

            tv.text = formatted
        }
    }
}
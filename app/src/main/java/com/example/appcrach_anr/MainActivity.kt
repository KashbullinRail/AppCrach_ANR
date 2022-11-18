package com.example.appcrach_anr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val btnCrash: Button by lazy { findViewById(R.id.btnCrash) }
    private val tvSifre: TextView by lazy { findViewById(R.id.tvSifre) }
    private var timerValue: Int = 20
    private var thread: Thread? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCrash.setOnClickListener {
            startTimer()
        }

    }

    private fun startTimer() {
        thread = Thread {
            for (i in 20 downTo 0) {
                timerValue = i
                updateUI()
                Thread.sleep(1000)
            }
            runOnUiThread { stopTimer() }
        }
        thread?.start()
    }

    private fun stopTimer() {
        thread = null
        timerValue = 20
        updateUI()
    }

    private fun updateUI() {
        tvSifre.text = timerValue.toString()
        btnCrash.isEnabled = thread == null
    }


}
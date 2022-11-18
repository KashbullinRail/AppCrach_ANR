package com.example.appcrach_anr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlin.random.Random

class HandlerActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val token = Any()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

//        binding.root.forEach {
//            if (it is Button) it.setOnClickListener(universalButtonListener)
//        }

    }

    private val universalButtonListener = View.OnClickListener {
        Thread{
            when(it.id){
                R.id.enableDisableButton ->
                    handler.post { toggleTestButtonState() }
                R.id.DisableButton ->
                    handler.postDelayed({ TestButtonState()}, DELAY)
                R.id.enableButton ->
                    handler.postDelayed({toggleButtonState()}, token, DELAY)
                R.id.btnCancel -> handler.removeCallbacksAndMessages(token)
            }
        }.start()
    }

    private fun randomColor(){
        val randomColor = Random.nextInt(255*255*255)
        btnClick.setBackgroundColor(randomColor)
    }

}
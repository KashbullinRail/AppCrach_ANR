package com.example.appcrach_anr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

class HandlerActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

//        binding.root.forEach {
//            if (it is Button) it.setOnClickListener(universalButtonListener)
//        }

    }

    private val universalButtonListener = View.OnClickListener {
        Thread{
//            when(it.id){
//                R.id.enableDisableButton ->
//                    handler.post { toggleTestButtonState }
//                R.id.DisableButton ->
//                    handler.post { TestButtonState }
//                R.id.enableButton ->
//                    handler.post { toggleButtonState }
//            }
        }.start()


    }

}
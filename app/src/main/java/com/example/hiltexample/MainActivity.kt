package com.example.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiltexample.api.ApiClientComObj

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClientComObj.getInstance(baseContext)
    }
}
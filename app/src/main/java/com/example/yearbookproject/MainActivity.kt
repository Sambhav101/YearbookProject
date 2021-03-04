package com.example.yearbookproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openFeed(view: View) {
        val intent = Intent(this, SambhavActivity::class.java)
        startActivity(intent)

    }

    fun openWebView(view: View) {
        val intent = Intent(this, WebviewActivity::class.java)
        startActivity(intent)
    }

}
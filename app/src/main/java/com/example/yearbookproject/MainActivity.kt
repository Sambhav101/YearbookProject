package com.example.yearbookproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


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
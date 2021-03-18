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

    override fun onPause() {
        super.onPause();

        object : CountDownTimer(30000, 1000) {
            override fun onTick(l: Long) {}
            override fun onFinish() {

                // Create an explicit intent for an Activity in your app
                val intent = Intent(this@MainActivity, MainActivity::class.java).apply {
                    var flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                val pendingIntent: PendingIntent = PendingIntent.getActivity(this@MainActivity, 0, intent, 0)

                val builder = NotificationCompat.Builder(this@MainActivity, "channel1")
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Don't Leave us")
                        .setContentText("Click me to return to the app!")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)


                with(NotificationManagerCompat.from(this@MainActivity)) {
                    // notificationId is a unique int for each notification that you must define
                    notify(1, builder.build())
                }
            }
        }.start()
    }

    fun openFeed(view: View) {
        val intent = Intent(this, SambhavActivity::class.java)
        startActivity(intent)
    }

    fun openWebView(view: View) {
        val intent = Intent(this, WebviewActivity::class.java)
        startActivity(intent)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("channel1", "Return to App", importance)
            // Register the channel with the system
            val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
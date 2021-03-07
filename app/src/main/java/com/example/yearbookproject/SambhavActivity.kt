package com.example.yearbookproject

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider.getUriForFile
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.security.AccessController.getContext


class SambhavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sambhav)

    }

    fun home(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun next_p(view: View) {
        val intent = Intent(this, VanessaActivity::class.java)
        startActivity(intent)
    }

    fun share(view: View) {
        val uri = Uri.parse("android.resource://com.example.yearbookproject/drawable/cat")
        val stream: InputStream? = contentResolver.openInputStream(uri)

        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uri)
            type = "image/jpg"
        }
        startActivity(Intent.createChooser(shareIntent, "send to"))


    }


}
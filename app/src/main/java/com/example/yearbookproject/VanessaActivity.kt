package com.example.yearbookproject

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.io.InputStream


class VanessaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vanessa)

        val post_image = findViewById<View>(R.id.imageView3) as ImageView
        val myDrawable = post_image.drawable
        val bitmap = (myDrawable as BitmapDrawable).bitmap

        val Share = findViewById<Button>(R.id.button4)
        Share.setOnClickListener {
            try {
                val file = File(externalCacheDir, "logo.png")
                val fOut = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
                fOut.flush()
                fOut.close()
                file.setReadable(true, false)
                val intent = Intent(android.content.Intent.ACTION_SEND)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
                intent.type = "image/png"
                startActivity(Intent.createChooser(intent, "Share image via"))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun home(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun next_p(view: View) {
        val intent = Intent(this, SambhavActivity::class.java)
        startActivity(intent)
    }

    fun share(view: View) {
        val uri = Uri.parse("android.resource://com.example.yearbookproject/drawable/account_circle_black_18dp_")
        val stream: InputStream? = contentResolver.openInputStream(uri)

        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uri)
            type = "image/jpg"
        }
        startActivity(Intent.createChooser(shareIntent, "send to"))

    }
}

package com.example.firstappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var REQUEST_KEY: Int = 77


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendActivity()

    }

        fun sendActivity() {
            val textFirstActivity = first_text.text.toString().trim()
            if (textFirstActivity.isNotEmpty()) {
                startActivityForResult(
                    Intent(this, Second::class.java).putExtra("key", textFirstActivity)
                    , REQUEST_KEY
                )
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_KEY && resultCode == RESULT_OK && data != null) {
                val newText = data.getStringExtra("key")
                text_from2.text = newText
            }
        }
    }

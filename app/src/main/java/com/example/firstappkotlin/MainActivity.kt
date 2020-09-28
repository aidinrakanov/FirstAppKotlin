package com.example.firstappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var name: String = "Please enter text"
    var REQUEST_KEY: Int = 77


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        private fun toast(name: String) {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }

        fun btnFirstActivity(view: View) {
            val textFirstActivity = first_text.text.toString().trim()
            if (textFirstActivity.isNotEmpty()) {
                startActivityForResult(
                    Intent(this, Second::class.java).putExtra("key", textFirstActivity)
                    , REQUEST_KEY
                )
            } else {
                toast(name)
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_KEY && resultCode == RESULT_OK && data != null) {
                val newText = data.getStringExtra("key")
                text_from2.text = newText
            }
        }
    }}
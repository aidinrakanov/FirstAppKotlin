package com.example.firstappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {
        lateinit var text: String
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_second)
            showTextFirstActivity()
        }

        private fun showTextFirstActivity() {
            val getText = intent
            text = getText.getStringExtra("key") as String
            second_text.setText(text)
        }

        fun onSendBack(view: View) {
            val newText = second_text.text.toString().trim()
            if (newText.isNotEmpty()) {
                intent.putExtra("key", newText)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
}
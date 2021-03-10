package com.draakoon.loginparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val userName = intent.getStringExtra("user_name") // Get username from arguments

        val buttonLogOut = findViewById<Button>(R.id.logout_button)
        val user: TextView = findViewById(R.id.user_name)

        user.text = userName

        buttonLogOut.setOnClickListener {
            finish()
        }
    }
}
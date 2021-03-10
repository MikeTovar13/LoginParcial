package com.draakoon.loginparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val users = listOf("michaelf.tovart@ecci.edu.co", "cmunozp@ecci.edu.co");

        val buttonLogin = findViewById<Button>(R.id.loginButton);
        val emailObj = findViewById<TextView>(R.id.emailInput);
        val passwordObj = findViewById<TextView>(R.id.passwordInput);

        buttonLogin.setOnClickListener {

            val email = emailObj.text.toString();
            val password = passwordObj.text.toString();

            if (email == "") {
                this.loginError(R.string.user_required)
            } else if (password == "") {
                this.loginError(R.string.password_required)
            } else {
                if (!users.contains(email) || password.length < 4) {
                    this.loginError(R.string.user_password_invalid)
                } else {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra("user_name", email);
                    startActivity(intent);
                    this.loginError(R.string.value_void)
                    emailObj.setText(R.string.value_void)
                    passwordObj.setText(R.string.value_void)
                }
            }
            
            return@setOnClickListener;
        }
    }
    private fun loginError(textShow: Int) {
        val validationObj = findViewById<TextView>(R.id.validation);
        validationObj.setText(textShow);
    }
}
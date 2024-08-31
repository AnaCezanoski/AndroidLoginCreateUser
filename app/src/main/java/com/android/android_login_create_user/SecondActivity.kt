package com.android.android_login_create_user

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var newUsernameEditText: EditText
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        newUsernameEditText = findViewById(R.id.newUsernameEditText)
        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)

        saveButton.setOnClickListener {
            val username = newUsernameEditText.text.toString()
            val password = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                val intent = Intent()
                intent.putExtra("username", username)
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Check that all fields are filled in and that the passwords match..", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}

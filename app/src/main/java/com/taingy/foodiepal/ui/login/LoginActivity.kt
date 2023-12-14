package com.taingy.foodiepal.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.taingy.foodiepal.databinding.ActivityLoginBinding
import com.taingy.foodiepal.ui.main.HomeActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val users = listOf<User>(
        User("Taingy", "taingy@miu.edu", "123456")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isLoggedIn()
        binding.btLogin.setOnClickListener { performLogin() }
    }

    private fun performLogin() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val myPreferences = getSharedPreferences("MyPreference", MODE_PRIVATE)
        val editor = myPreferences.edit()

        val user = users.firstOrNull() { it.username == email && it.password == password }
        if (user != null) {
            editor.putBoolean(Credential.IS_LOGIN.name, true)
            editor.putString(Credential.FULL_NAME.name, user.fullName)
            editor.apply()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Invalid credential!", Toast.LENGTH_LONG).show()
        }
    }

    private fun isLoggedIn() {
        val myPreferences = getSharedPreferences("MyPreference", MODE_PRIVATE)
        val login = myPreferences.getBoolean(Credential.IS_LOGIN.name, false)

        if (login) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}

enum class Credential {
    IS_LOGIN, FULL_NAME
}
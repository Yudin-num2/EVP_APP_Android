package ru.europlast.evpapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.europlast.evpapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding from ${this.localClassName} must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnAuthButton.setOnClickListener{
            authFunction()
        }

    }
    private fun authFunction() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
//        TODO add auth with postgre client with REST API
        finish()
    }
    }
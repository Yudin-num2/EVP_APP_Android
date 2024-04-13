package ru.europlast.evpapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
            testFunction()
        }

    }
    private fun testFunction() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    }
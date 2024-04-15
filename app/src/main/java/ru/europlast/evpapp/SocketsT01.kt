package ru.europlast.evpapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.europlast.evpapp.databinding.ActivitySocketsT01Binding

class SocketsT01 : AppCompatActivity() {

    private var _binding: ActivitySocketsT01Binding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding from ${this.localClassName} must not be null"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySocketsT01Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
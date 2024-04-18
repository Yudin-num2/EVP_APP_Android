package ru.europlast.evpapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.europlast.evpapp.databinding.ActivitySocketsT1Binding


class SocketsT01Activity : AppCompatActivity() {

    private var _binding: ActivitySocketsT1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivitySocketsT1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//        setContentView(R.layout.activity_sockets_t01)
    }


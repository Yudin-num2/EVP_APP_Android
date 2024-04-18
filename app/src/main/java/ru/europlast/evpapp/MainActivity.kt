package ru.europlast.evpapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ru.europlast.evpapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding from ${this.localClassName} must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSockets.setOnClickListener{
            showPopupMenu(it)
        }
        }

    private fun showPopupMenu(v: View) {
        val machines = arrayOf("Telerobot 1", "Telerobot 2", "Telerobot 3", "Telerobot 4",
                                "Telerobot 5", "Telerobot 6", "Telerobot 7")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Выберите комплекс")
        builder.setItems(machines) { _, which ->
            if (machines[which] == "Telerobot 1"){
                val intent = Intent(this, SocketsT01Activity::class.java)
                startActivity(intent)
            }

        }
        builder.show()
    }

}


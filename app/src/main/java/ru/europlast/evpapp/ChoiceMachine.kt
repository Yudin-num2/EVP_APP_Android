package ru.europlast.evpapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class ChoiceMachine: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_machine)

        val listOfButtons = listOf(
            findViewById<AppCompatButton>(R.id.btnTPALid),
            findViewById<AppCompatButton>(R.id.btnTPAFrame),
            findViewById<AppCompatButton>(R.id.btnTPACutter),
            )
        for (btn in listOfButtons){
            btn.setOnClickListener{
                val intent = Intent(this, Sockets48::class.java)
                intent.putExtra("HEADER", btn.text)
                startActivity(intent)
            }
        }
    }
}



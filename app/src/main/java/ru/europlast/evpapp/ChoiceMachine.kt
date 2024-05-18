package ru.europlast.evpapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible

class ChoiceMachine: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_machine)
        val telerobotName = intent.getStringExtra("TelerobotName")

        val listOfButtons = listOf(
            findViewById<AppCompatButton>(R.id.btnTPALid),
            findViewById<AppCompatButton>(R.id.btnTPAFrame),
            findViewById<AppCompatButton>(R.id.btnTPACutter),
            findViewById<AppCompatButton>(R.id.btnTPALid12),
            findViewById<AppCompatButton>(R.id.btnTPAFrame12),
            findViewById<AppCompatButton>(R.id.btnTPACutter12),
            )
        val lastThreeButtons = listOfButtons.subList(
            listOfButtons.size - 3,
            listOfButtons.size)
        if (telerobotName!!.contains("1")){
            lastThreeButtons.forEach{it.isVisible = true}
        }else{
            lastThreeButtons.forEach{it.isVisible = false}
        }
        for (btn in listOfButtons){
            btn.setOnClickListener{
                if ("12" in btn.text){
                    val intent = Intent(this, Sockets12::class.java)
                    intent.putExtra("HEADER", btn.text)
                    intent.putExtra("TelerobotName", telerobotName)
                    startActivity(intent)
                }else{
                    val intent = Intent(this, Sockets48::class.java)
                    intent.putExtra("HEADER", btn.text)
                    intent.putExtra("TelerobotName", telerobotName)
                    startActivity(intent)}
            }
        }
    }
}



package ru.europlast.evpapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Sockets48: AppCompatActivity() {
    private val buttonColors = mutableMapOf<AppCompatButton, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sockets_lid_48)

        val listOfButtons = listOf<AppCompatButton>(
            findViewById(R.id.btnSocket1), findViewById(R.id.btnSocket2),
            findViewById(R.id.btnSocket3), findViewById(R.id.btnSocket4),
            findViewById(R.id.btnSocket5), findViewById(R.id.btnSocket6),
            findViewById(R.id.btnSocket7), findViewById(R.id.btnSocket8),
            findViewById(R.id.btnSocket9), findViewById(R.id.btnSocket10),
            findViewById(R.id.btnSocket11), findViewById(R.id.btnSocket12),
            findViewById(R.id.btnSocket13), findViewById(R.id.btnSocket14),
            findViewById(R.id.btnSocket15), findViewById(R.id.btnSocket16),
            findViewById(R.id.btnSocket17), findViewById(R.id.btnSocket18),
            findViewById(R.id.btnSocket19), findViewById(R.id.btnSocket20),
            findViewById(R.id.btnSocket21), findViewById(R.id.btnSocket22),
            findViewById(R.id.btnSocket23), findViewById(R.id.btnSocket24),
            findViewById(R.id.btnSocket25), findViewById(R.id.btnSocket26),
            findViewById(R.id.btnSocket27), findViewById(R.id.btnSocket28),
            findViewById(R.id.btnSocket29), findViewById(R.id.btnSocket30),
            findViewById(R.id.btnSocket31), findViewById(R.id.btnSocket32),
            findViewById(R.id.btnSocket33), findViewById(R.id.btnSocket34),
            findViewById(R.id.btnSocket35), findViewById(R.id.btnSocket36),
            findViewById(R.id.btnSocket37), findViewById(R.id.btnSocket38),
            findViewById(R.id.btnSocket39), findViewById(R.id.btnSocket40),
            findViewById(R.id.btnSocket41), findViewById(R.id.btnSocket42),
            findViewById(R.id.btnSocket43), findViewById(R.id.btnSocket44),
            findViewById(R.id.btnSocket45), findViewById(R.id.btnSocket46),
            findViewById(R.id.btnSocket47), findViewById(R.id.btnSocket48),
        )
        for (btn in listOfButtons){
            btn.setOnClickListener{
                showPopupMenu(btn)
            }
        }
        val header = findViewById<TextView>(R.id.tvHeader)
        header.text = """
        ${intent.getStringExtra("TelerobotName")} | ${intent.getStringExtra("HEADER")}
            """.trimIndent()
        val btnSaveAndExit = findViewById<AppCompatButton>(R.id.btn_save_and_exit)
        btnSaveAndExit.setOnClickListener{
            saveAndExit()}
    }

    private fun saveAndExit() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.checking_data)
        val message = StringBuilder()
        buttonColors.forEach { (button, color) ->
            message.append("${getString(R.string.socket)} № ${button.text} - $color\n")}
            builder.setMessage(
"""
${intent.getStringExtra("TelerobotName")} | ${intent.getStringExtra("HEADER")}
$message
""".trimIndent()
                )
            builder.setPositiveButton("Да") { _, _ ->
                buttonColors.clear()
                finish()
            }
            builder.setNegativeButton("Нет") { dialog, _ ->
                buttonColors.clear()
                for (btn in buttonColors.keys) {
                    btn.setBackgroundResource(R.drawable.ic_good_socket_button)
                }
                dialog.dismiss()

            }
            builder.show()
//TODO в дальнейшем брать предыдущий цвет кнопки (она не обязательно могла быть "good_socket")
//TODO Реализовать после получения данных из PostgreSQL реальных данных по гнёздам


    }

    private fun showPopupMenu(button: AppCompatButton) {

//        val colorIndex: Map<String, Int> = mapOf(
//            R.string.underfilling.toString() to 1,
//            R.string.dirt.toString() to 2,
//            R.string.needle_chipping.toString() to 3,
//            R.string.flash_by_closure.toString() to 4,
//            "crack" to 5,
//            "hole" to 6,
//            "gate_valve" to 7,
//            "not_warm" to 8,
//            "geometry" to 9,
//            "water" to 10,
//            "good_socket" to 11,
//
//        ) TODO Вроде и не нужно нахрен

        val reasonsSocket = arrayOf(
            getString(R.string.underfilling),
            getString(R.string.dirt),
            getString(R.string.needle_chipping),
            getString(R.string.flash_by_closure),
            getString(R.string.crack),
            getString(R.string.hole),
            getString(R.string.gate_valve),
            getString(R.string.not_warm),
            getString(R.string.geometry),
            getString(R.string.water),
            getString(R.string.good_socket)
        )

        val selectedSocket = R.string.selected_socket
        val selectReason = R.string.select_reason

        val builder = AlertDialog.Builder(this)
        builder.setTitle("$selectedSocket ${button.text}\n$selectReason")
        builder.setItems(reasonsSocket) { _, which ->
            when (reasonsSocket[which]) {
                getString(R.string.underfilling) -> {
                    button.setBackgroundResource(R.drawable.ic_underfilling_socket_button)
                buttonColors[button] = reasonsSocket[which]}
                getString(R.string.dirt) -> {
                    button.setBackgroundResource(R.drawable.ic_dirt_socket_button)
                buttonColors[button] = reasonsSocket[which]}
                getString(R.string.needle_chipping) -> {
                    button.setBackgroundResource(R.drawable.ic_needle_chipping_socket_button)
                buttonColors[button] = reasonsSocket[which]}
                getString(R.string.flash_by_closure) -> {
                    button.setBackgroundResource(R.drawable.ic_flash_by_closure_socket_button)
                buttonColors[button] = reasonsSocket[which]}
                getString(R.string.crack) -> {
                    button.setBackgroundResource(R.drawable.ic_crack_socket_button)
                buttonColors[button] = reasonsSocket[which]}
                getString(R.string.hole) -> {
                    button.setBackgroundResource(R.drawable.ic_hole_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
                getString(R.string.gate_valve) -> {
                    button.setBackgroundResource(R.drawable.ic_gate_valve_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
                    getString(R.string.not_warm) -> {
                    button.setBackgroundResource(R.drawable.ic_not_warm_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
                getString(R.string.geometry) -> {
                    button.setBackgroundResource(R.drawable.ic_geometry_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
                getString(R.string.water) -> {
                    button.setBackgroundResource(R.drawable.ic_water_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
                getString(R.string.good_socket) -> {
                    button.setBackgroundResource(R.drawable.ic_good_socket_button)
                    buttonColors[button] = reasonsSocket[which]}
            }
        }
        builder.show()
    }
}
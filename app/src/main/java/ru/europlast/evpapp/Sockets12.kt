package ru.europlast.evpapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Sockets12: AppCompatActivity() {
    private val buttonColors = mutableMapOf<AppCompatButton, String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sockets_lid_12)

        val listOfButtons = listOf<AppCompatButton>(
            findViewById(R.id.btnSocket1_12), findViewById(R.id.btnSocket2_12),
            findViewById(R.id.btnSocket3_12), findViewById(R.id.btnSocket4_12),
            findViewById(R.id.btnSocket5_12), findViewById(R.id.btnSocket6_12),
            findViewById(R.id.btnSocket7_12), findViewById(R.id.btnSocket8_12),
            findViewById(R.id.btnSocket9_12), findViewById(R.id.btnSocket10_12),
            findViewById(R.id.btnSocket11_12), findViewById(R.id.btnSocket12_12),
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
            for (btn in buttonColors.keys) {
                btn.setBackgroundResource(R.drawable.ic_good_socket_button)
//TODO в дальнейшем брать предыдущий цвет кнопки (она не обязательно могла быть "good_socket")
//TODO Реализовать после получения данных из PostgreSQL реальных данных по гнёздам
            }
            buttonColors.clear()
            dialog.dismiss()

        }
        builder.show()



    }

    private fun showPopupMenu(button: AppCompatButton) {

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
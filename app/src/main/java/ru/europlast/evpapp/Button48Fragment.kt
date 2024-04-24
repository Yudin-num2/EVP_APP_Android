package ru.europlast.evpapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class Button48Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_button_48, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfButtons = listOf<AppCompatButton>(
            view.findViewById(R.id.btnSocket1), view.findViewById(R.id.btnSocket2),
            view.findViewById(R.id.btnSocket3), view.findViewById(R.id.btnSocket4),
            view.findViewById(R.id.btnSocket5), view.findViewById(R.id.btnSocket6),
            view.findViewById(R.id.btnSocket7), view.findViewById(R.id.btnSocket8),
            view.findViewById(R.id.btnSocket9), view.findViewById(R.id.btnSocket10),
            view.findViewById(R.id.btnSocket11), view.findViewById(R.id.btnSocket12),
            view.findViewById(R.id.btnSocket13), view.findViewById(R.id.btnSocket14),
            view.findViewById(R.id.btnSocket15), view.findViewById(R.id.btnSocket16),
            view.findViewById(R.id.btnSocket17), view.findViewById(R.id.btnSocket18),
            view.findViewById(R.id.btnSocket19), view.findViewById(R.id.btnSocket20),
            view.findViewById(R.id.btnSocket21), view.findViewById(R.id.btnSocket22),
            view.findViewById(R.id.btnSocket23), view.findViewById(R.id.btnSocket24),
            view.findViewById(R.id.btnSocket25), view.findViewById(R.id.btnSocket26),
            view.findViewById(R.id.btnSocket27), view.findViewById(R.id.btnSocket28),
            view.findViewById(R.id.btnSocket29), view.findViewById(R.id.btnSocket30),
            view.findViewById(R.id.btnSocket31), view.findViewById(R.id.btnSocket32),
            view.findViewById(R.id.btnSocket33), view.findViewById(R.id.btnSocket34),
            view.findViewById(R.id.btnSocket35), view.findViewById(R.id.btnSocket36),
            view.findViewById(R.id.btnSocket37), view.findViewById(R.id.btnSocket38),
            view.findViewById(R.id.btnSocket39), view.findViewById(R.id.btnSocket40),
            view.findViewById(R.id.btnSocket41), view.findViewById(R.id.btnSocket42),
            view.findViewById(R.id.btnSocket43), view.findViewById(R.id.btnSocket44),
            view.findViewById(R.id.btnSocket45), view.findViewById(R.id.btnSocket46),
            view.findViewById(R.id.btnSocket47), view.findViewById(R.id.btnSocket48),
        )
        for (btn in listOfButtons){
            btn.setOnClickListener{
                showPopupMenu(btn)
            }
        }
    }

    private fun showPopupMenu(button: Button) {
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

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Выбрано гнездо №${button.text}\nВыберите причину")
        builder.setItems(reasonsSocket) { _, which ->
            when (reasonsSocket[which]) {
                getString(R.string.underfilling) ->
                    button.setBackgroundResource(R.drawable.ic_underfilling_socket_button)
                getString(R.string.dirt) ->
                    button.setBackgroundResource(R.drawable.ic_dirt_socket_button)
                getString(R.string.needle_chipping) ->
                    button.setBackgroundResource(R.drawable.ic_needle_chipping_socket_button)
                getString(R.string.flash_by_closure) ->
                    button.setBackgroundResource(R.drawable.ic_flash_by_closure_socket_button)
                getString(R.string.crack) ->
                    button.setBackgroundResource(R.drawable.ic_crack_socket_button)
                getString(R.string.hole) ->
                    button.setBackgroundResource(R.drawable.ic_hole_socket_button)
                getString(R.string.gate_valve) ->
                    button.setBackgroundResource(R.drawable.ic_gate_valve_socket_button)
                getString(R.string.not_warm) ->
                    button.setBackgroundResource(R.drawable.ic_not_warm_socket_button)
                getString(R.string.geometry) ->
                    button.setBackgroundResource(R.drawable.ic_geometry_socket_button)
                getString(R.string.water) ->
                    button.setBackgroundResource(R.drawable.ic_water_socket_button)
                getString(R.string.good_socket) ->
                    button.setBackgroundResource(R.drawable.ic_good_socket_button)
            }
        }
        builder.show()
    }
}


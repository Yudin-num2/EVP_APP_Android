package ru.europlast.evpapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class Button12Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_button_12, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfButtons = listOf<AppCompatButton>(
            view.findViewById(R.id.btnSocket1_12), view.findViewById(R.id.btnSocket2_12),
            view.findViewById(R.id.btnSocket3_12), view.findViewById(R.id.btnSocket4_12),
            view.findViewById(R.id.btnSocket5_12), view.findViewById(R.id.btnSocket6_12),
            view.findViewById(R.id.btnSocket7_12), view.findViewById(R.id.btnSocket8_12),
            view.findViewById(R.id.btnSocket9_12), view.findViewById(R.id.btnSocket10_12),
            view.findViewById(R.id.btnSocket11_12), view.findViewById(R.id.btnSocket12_12),
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


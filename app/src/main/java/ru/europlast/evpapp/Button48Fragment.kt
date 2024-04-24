package ru.europlast.evpapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class Button48Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_button_48, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnSocket1)
        button.setOnClickListener {
            showPopupMenu(button)
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
        builder.setTitle("Выберите причину")
        builder.setItems(reasonsSocket) { _, which ->
            when (reasonsSocket[which]) {
                getString(R.string.underfilling) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.underfilling))
                getString(R.string.dirt) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.dirt))
                getString(R.string.needle_chipping) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.needle_chipping))
                getString(R.string.flash_by_closure) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.flash_by_closure))
                getString(R.string.crack) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.crack))
                getString(R.string.hole) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.hole))
                getString(R.string.gate_valve) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.gate_valve))
                getString(R.string.not_warm) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.not_warm))
                getString(R.string.geometry) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.geometry))
                getString(R.string.water) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.water))
                getString(R.string.good_socket) ->
                    button.setBackgroundColor(
                        ContextCompat.getColor(requireContext(), R.color.socket_good))
            }
        }
        builder.show()
    }
}


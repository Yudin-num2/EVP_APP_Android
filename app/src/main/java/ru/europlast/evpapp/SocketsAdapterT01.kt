package ru.europlast.evpapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SocketsAdapterT01(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return if (position < 3) {
            Button48Fragment()
        } else {
            Button12Fragment()
        }
    }
    override fun getItemCount(): Int = 6
}


package ru.europlast.evpapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SocketsT01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sockets_t1)

        val adapter = SocketsAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.pager)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabl)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Lid"
                1 -> tab.text = "Frame"
                2 -> tab.text = "Cutter"
                3 -> tab.text = "Lid\n12"
                4 -> tab.text = "Frame\n12"
                5 -> tab.text = "Cutter\n12"
            }
        }.attach()

    }

}

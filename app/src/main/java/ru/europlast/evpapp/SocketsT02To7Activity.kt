package ru.europlast.evpapp

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SocketsT02To7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sockets_t2_to_7)

        val adapter = SocketsAdapterT02To7(this)
        val viewPager = findViewById<ViewPager2>(R.id.pager_t02_to_7)
        viewPager.adapter = adapter
        window.setBackgroundDrawable(ColorDrawable(
            ContextCompat.getColor(this, R.color.evp_cyan)))

        val tabLayout = findViewById<TabLayout>(R.id.tabl_t02_to_7)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Lid"
                1 -> tab.text = "Frame"
                2 -> tab.text = "Cutter"
            }
        }.attach()


    }

}

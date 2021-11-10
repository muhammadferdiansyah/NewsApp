package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val vpNews = findViewById<ViewPager2>(R.id.vp_news)
        vpNews.adapter = SectionPagerAdapter(this)


        val tabs = findViewById<TabLayout>(R.id.tabs)

        val list = arrayOf("All News", "Top", "Popular")
        TabLayoutMediator(tabs,vpNews){ tab, position ->
            tab.text = list[position]
        }.attach()
    }
}
package com.taingy.foodiepal.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.taingy.foodiepal.R
import com.taingy.foodiepal.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = pagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        binding.navBottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_recipes -> viewPager.setCurrentItem(0, true)
                R.id.nav_planner -> viewPager.setCurrentItem(1, true)
                R.id.nav_blog -> viewPager.setCurrentItem(2, true)
            }
            return@setOnItemSelectedListener true
        }

    }
}



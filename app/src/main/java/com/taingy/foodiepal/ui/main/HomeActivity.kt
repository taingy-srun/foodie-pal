package com.taingy.foodiepal.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.taingy.foodiepal.R
import com.taingy.foodiepal.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val TAB_TITLES = arrayOf("Recipes", "Planner", "Blog", "Contact", "About Me")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFragmentsAndTabLayout()
        setUpNavigationBottom()
    }

    private fun setUpFragmentsAndTabLayout() {
        val fragments = listOf(
            RecipesFragment(),
            MealPlannerFragment(),
            BlogFragment(),
            ContactFragment(),
            AboutMeFragment()
        )
        val viewPager: ViewPager2 = binding.viewPager
        val viewPagerAdapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter

        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, pos ->
            tab.text = TAB_TITLES[pos]
        }.attach()
    }

    private fun setUpNavigationBottom() {
        val navBottom = binding.navBottomMenu
        val viewPager = binding.viewPager
        navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_recipes -> viewPager.setCurrentItem(0, true)
                R.id.nav_planner -> viewPager.setCurrentItem(1, true)
                R.id.nav_blog -> viewPager.setCurrentItem(2, true)
            }
            return@setOnItemSelectedListener true
        }
    }
}



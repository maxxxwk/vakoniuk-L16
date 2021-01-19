package com.maxxxwk.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.maxxxwk.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val countries = listOf(
            Country("Ukraine", 41.98, 0.603628),
            Country("Russia", 144.5, 17.1),
            Country("USA", 328.2, 9.834),
            Country("Japan", 126.5, 0.377915),
            Country("China", 1393.0, 9.597),
            Country("Australia", 24.99, 7.692),
            Country("Germany", 83.2, 0.357386)
        )
        binding.viewPager.adapter = CountryAdapter(this, countries)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = countries[position].name
        }.attach()
    }
}
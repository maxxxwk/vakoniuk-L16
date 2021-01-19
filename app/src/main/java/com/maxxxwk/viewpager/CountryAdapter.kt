package com.maxxxwk.viewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CountryAdapter(activity: AppCompatActivity, private val countries: List<Country>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = countries.size

    override fun createFragment(position: Int): Fragment =
        CountryInfoFragment.newInstance(countries[position])
}
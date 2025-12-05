package ru.monjaro.mconfig

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fm: FragmentActivity, private var totalTabs: Int) : FragmentStateAdapter(fm)  {
    // this is for fragment tabs
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
               DataFragment()
            }

            1 -> {
                SettingsFragment()
            }
            2 -> {
                ClimateFragment()
            }
            3 -> {
                StartAppsFragment()
            }
            else -> DataFragment()
        }
    }

    // this counts total number of tabs
    override fun getItemCount(): Int {
        return totalTabs
    }
}
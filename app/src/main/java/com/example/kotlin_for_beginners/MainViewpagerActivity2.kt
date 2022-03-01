package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_for_beginners.databinding.ActivityMainViewpager2Binding
import com.google.android.material.tabs.TabLayoutMediator

class MainViewpagerActivity2 : AppCompatActivity() {
    val binding by lazy { ActivityMainViewpager2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textList = listOf("뷰a","뷰b","뷰c","뷰d")
        val customAdapter = CustomPagerAdapter()
        customAdapter.textList = textList
        binding.viewpager2.adapter = customAdapter
        val tabTitles = listOf("veiw a","veiw b","veiw c","veiw d")
        TabLayoutMediator(binding.viewTablayout,binding.viewpager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_for_beginners.databinding.ActivityMainViewpagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainViewpagerActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainViewpagerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(FragmentA(),FragmentB(),FragmentC(),FragmentD())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList =fragmentList

        binding.viewPager.adapter = adapter


        val tabTitle = listOf<String>("A","B","C","D")
        TabLayoutMediator(binding.tabLayout,binding.viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}
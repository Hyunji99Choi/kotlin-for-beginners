package com.example.kotlin_for_beginners

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding

class MainRecyclerView : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
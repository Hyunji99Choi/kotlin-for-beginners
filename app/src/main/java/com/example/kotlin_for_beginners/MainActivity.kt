package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        //어떻게 메인액티비티와 연결되는가,, 전부 연결되는거 아님?
        setContentView(binding.root)


        //뷰바인딩 변수.id
        binding.btnSay.setOnClickListener {
            binding.textSay.text = "Hello Kotlin!!"
        }

    }
}
package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


        var stringArray = Array(10,{item->""})
        Log.d("BasicSyntax"," 현재시간은 ${stringArray.get(1)}")


        var set = mutableSetOf<String>()
        set.add("aid")
        set.add("bid")

        var map = mutableMapOf<String,String>()
        Log.d("BasicSyntax"," map ${map.get("key")}")

        for(index in 10 downTo 0){
            Log.d("BasicSyntax"," index = ${index}")
        }
    }
}


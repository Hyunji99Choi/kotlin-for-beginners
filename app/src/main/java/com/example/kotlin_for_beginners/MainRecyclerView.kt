package com.example.kotlin_for_beginners

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding
import com.example.kotlin_for_beginners.databinding.ActivityRecyclerviewBinding

class MainRecyclerView : AppCompatActivity() {
    //_ -> 대문자 + Binding
    val binding by lazy { ActivityRecyclerviewBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data:MutableList<Memo> = loadData() //데이터 생성(임의)

        //어뎁터 클래스 생성
        var adapter = CustomAdapter()
        //어뎁터 변수에 데이터 넣어주기
        adapter.listData = data

        //위젯에에 어뎁터 연결
        binding.recyclerView.adapter = adapter

        //레이아웃 매니저 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    fun loadData(): MutableList<Memo> {
        val data:MutableList<Memo> = mutableListOf()
        for(no in 1..100){
            val title="이것이 안드로이드다 ${no}"
            val date = System.currentTimeMillis()

            var memo = Memo(no,title,date)
            data.add(memo)
        }
        return data
    }
}
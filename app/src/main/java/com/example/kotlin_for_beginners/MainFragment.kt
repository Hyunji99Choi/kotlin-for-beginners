package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding
import com.example.kotlin_for_beginners.databinding.ActivityMainFragmentBinding

class MainFragment : AppCompatActivity() {

    val binding by lazy { ActivityMainFragmentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        setFragment()
    }

    fun setFragment() {
        val listFragment: ListFragment = ListFragment()

        //액티비티가 가지고 있는 프래그먼트 매니저를 통해 트랜잭션 시작
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,listFragment)
        transaction.commit()
    }
}
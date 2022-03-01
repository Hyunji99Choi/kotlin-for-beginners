package com.example.kotlin_for_beginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding
import com.example.kotlin_for_beginners.databinding.ActivityMainFragmentBinding

class MainFragment : AppCompatActivity() {

    val binding by lazy { ActivityMainFragmentBinding.inflate(layoutInflater) }
    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()

        binding.btnSend.setOnClickListener {
            Log.d("btn","click")
            listFragment.setValue("전달할 값")
        }
    }

    fun setFragment() {
        listFragment= ListFragment()


        val bundle = Bundle()
        bundle.putString("key1","List Fragment")
        bundle.putInt("key2",20210101)
        listFragment.arguments =bundle
        //액티비티가 가지고 있는 프래그먼트 매니저를 통해 트랜잭션 시작
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,listFragment)
        transaction.commit()


    }

    fun goDetail() {
        val detailFragment = DetailFragment()

        //액티비티가 가지고 있는 프래그먼트 매니저를 통해 트랜잭션 시작
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
        onBackPressed() //뒤로가기가 필요할 때 액티비티에서 사용할 수 있는 기본 메서드
    }
}
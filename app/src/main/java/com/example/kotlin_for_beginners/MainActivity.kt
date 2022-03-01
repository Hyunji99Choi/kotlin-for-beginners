package com.example.kotlin_for_beginners

import android.R
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin_for_beginners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val binding = ActivityMainBinding.inflate(layoutInflater)
        //어떻게 메인액티비티와 연결되는가,, 전부 연결되는거 아님?
        setContentView(binding.root)


        //스피너
        var data = listOf("- 선택하세요 -","1월","2월","3월","4월","5월","6월")
        var adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1,data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.textSay.text = data.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        //bluetooth 사용할 수 있는지 여부 확인
        binding.blueBtn.setOnClickListener{
            val intent = Intent(this,MainBluetoothActivity::class.java)
            startActivity(intent)
        }

        //뷰바인딩 변수.id
        binding.btnSay.setOnClickListener {
            binding.textSay.text = "Hello Kotlin!!"
        }

        //btn event
        binding.nextBtn.setOnClickListener{
            val intent = Intent(this,MainRecyclerView::class.java)
            startActivity(intent)
        }
        binding.nextBtn2.setOnClickListener {
            val intent = Intent(this,MainFragment::class.java)
            startActivity(intent)
        }
        binding.viewpageBtn.setOnClickListener{
            val intent = Intent(this,MainViewpagerActivity::class.java)
            startActivity(intent)
        }
        binding.viewpageBtn2.setOnClickListener{
            val intent = Intent(this,MainViewpagerActivity2::class.java)
            startActivity(intent)
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


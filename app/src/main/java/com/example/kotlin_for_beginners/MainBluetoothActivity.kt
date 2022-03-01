package com.example.kotlin_for_beginners

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_for_beginners.BluetoothStateReceiver
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin_for_beginners.databinding.ActivityMainBluetoothBinding

class MainBluetoothActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBluetoothBinding.inflate(layoutInflater) }
    val btArrayAdapter by lazy {ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)}
    val bluetoothAdapter by lazy { BluetoothAdapter.getDefaultAdapter() }

    val BluetoothStateReceiver by lazy { BluetoothStateReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //화면의 타이틀바를 프로그레스바로 만들어 작업 진행을 알린다
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS)
        setContentView(binding.root)

        //btArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        binding.devicesfound.adapter = btArrayAdapter


        //블루투스 사용할 수 있는지 확인
        //bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if(bluetoothAdapter == null){
            Toast.makeText(this,"Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish()
            return
        }

        //intent 결과 받기
        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                //블루투스 활성화
                Log.d("blue","블루투스 활성화")

            }else{
                Log.d("blue","블루투스 실패")
                Toast.makeText(this,"블르투스 실패", Toast.LENGTH_SHORT).show()
                finish()
            }

        }

        ///

        binding.sacndevice.setOnClickListener{
            //블루투스 꺼져있니?
            if(bluetoothAdapter?.isEnabled == false){
                Log.d("blue","활성화 안됨")
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                activityResult.launch(enableBtIntent)
            }else{
                if(bluetoothAdapter.isDiscovering()){
                    //현재 검색을 진행중인지 확인
                    binding.bluetoothstate.text ="bluetooth is currently in device discovery process."
                    return@setOnClickListener
                }
                btArrayAdapter.clear()
                binding.bluetoothstate.text ="현재 작업중..."
                bluetoothAdapter.startDiscovery();
            }
        }

        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        filter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED)
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        registerReceiver(BluetoothStateReceiver,filter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(BluetoothStateReceiver)
    }
}
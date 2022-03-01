package com.example.kotlin_for_beginners

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

class BluetoothStateReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if(BluetoothDevice.ACTION_FOUND.equals(action)){
            val device: BluetoothDevice = intent.getParcelableArrayExtra(BluetoothDevice.EXTRA_DEVICE)
            Log.d("blue","${device.ge}")
        }else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){

        }else{

        }

    }


}
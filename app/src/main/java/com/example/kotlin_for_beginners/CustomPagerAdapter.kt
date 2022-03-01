package com.example.kotlin_for_beginners

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_for_beginners.databinding.ItemViewpagerBinding

class CustomPagerAdapter: RecyclerView.Adapter<VHolder>() {
    var textList = listOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return VHolder(binding)
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val text = textList[position]
        holder.setText(text)
    }

    override fun getItemCount(): Int {
        return textList.size
    }

}
class VHolder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root){

    fun setText(text:String){
        binding.textView4.text = text
    }
}
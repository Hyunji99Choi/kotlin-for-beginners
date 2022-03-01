package com.example.kotlin_for_beginners

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    var fragmentList = listOf<Fragment>()

    //어댑터가 화면에 보여줄 전체 프래그먼트의 개수를 반환
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    //현재 페이지의 position이 파라미터로 넘어옴. 해당 위치의 프래그먼트를 반환해야함
    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}
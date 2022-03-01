package com.example.kotlin_for_beginners

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_for_beginners.databinding.FragmentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    var mainActivity: MainFragment? = null
    lateinit var binding : FragmentListBinding

    //리사이클러뷰의 onCreateViewHolder() 메서드처럼 동작.
    //액티비티가 요청시 이 메서드를 통해 뷰를 만들어서 제공.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_list, container, false)

        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.fragBtn.setOnClickListener { mainActivity?.goDetail() }

        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainFragment) mainActivity = context
    }

    fun setValue(value:String) {
        binding.textFromActivity.text = value
    }
}
package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.comm.BaseFragment
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun initView() {
        binding.tv.text = "你是一个Fragment"

        binding.tv.run {
            setOnClickListener {
                binding.tv.text = KVManager.build().getParcelable("lcy", MainActivity.User::class.java)?.name
            }
        }
    }
}
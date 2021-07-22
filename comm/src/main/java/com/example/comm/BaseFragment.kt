package com.example.comm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    protected lateinit var binding: T

    abstract fun initView()

    abstract fun getViewBinding(inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container, savedInstanceState)
        initView()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
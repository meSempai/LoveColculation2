package com.example.lovecolculation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecolculation.remote.LoveModel
import com.geektech.lovecalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
        initListener()
    }

    private fun initListener() {
        binding.again.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun result() {
        with(binding) {
            val result = arguments?.getSerializable("Result") as LoveModel
            fname.text = result.firstName
            sname.text = result.secondName
            percent.text = result.percentage
            resultt.text = result.result
            findNavController().navigateUp()
        }
    }
}
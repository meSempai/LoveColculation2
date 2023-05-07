package com.example.lovecolculation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentHistoryBinding


@Suppress("UNREACHABLE_CODE")
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return  binding.root
        val list = App.appDatabase.getDao().getAllSort()
        Log.e("ololo", "onCreate: $list", )
        binding.tvHistory.text = list.toString().replace("[", "").replace("]", "")
    }
}
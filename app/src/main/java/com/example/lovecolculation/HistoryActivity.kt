package com.example.lovecolculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.geektech.lovecalculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var list = App.appDatabase.getDao().getAllSort()
        Log.e("ololo", "onCreate: $list", )
        binding.tvHistory.text = list.toString().replace("[", "").replace("]", "")

    }
}
package com.example.lovecolculation.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecolculation.App
import com.example.lovecolculation.HistoryFragment
import com.example.lovecolculation.LoveViewModel
import com.example.lovecolculation.remote.LoveModel
import com.example.lovecolculation.remote.RetrofitService
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class CalculateFragment : Fragment() {
    private lateinit var binding: FragmentCalculateBinding

    val ViewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnhistory.setOnClickListener {
                startActivity(Intent(this@CalculateFragment, HistoryFragment::class.java))
            }
            calculate.setOnClickListener {
                RetrofitService().api.percentageNames(firstName.text.toString(),
                    secondName.text.toString()).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            App.appDatabase.getDao()
                                .insert(LoveModel("firstname", "secondname", "", ""))
                            Log.e("ololo", "onResponse:${response.body()} ")
                            findNavController().navigate(R.id.resultt,
                                bundleOf("Result" to response.body()))
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message} ")
                    }


                })
            }
        }
    }
}
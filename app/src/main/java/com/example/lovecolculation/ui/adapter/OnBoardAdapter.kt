package com.example.lovecolculation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecolculation.R
import com.example.lovecolculation.databinding.ItemOnBoardBinding
import com.example.lovecolculation.ui.OnBoard

class OnBoardAdapter( private val onClick: () -> Unit) : RecyclerView.Adapter<OnBoardAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf<OnBoard>(
        OnBoard(
            R.drawable.first,
            "Have a good time You should take the time to help those who need you",
        ),
        OnBoard(
            R.drawable.second,
            "Cherishing Love It is now longer possible for you to cherish love",
        ),
        OnBoard(R.drawable.third,
            "Have a breakup? " +
                    "We have made the corretion for you don't worry " +
                    "Maybe someone is waiting for you!",
        ),
        OnBoard(R.drawable.four,
            "It's Funs and Many more",

            )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvDesc.text=onBoard.title
            onBoard.image?.let { binding.imgBoard.setImageResource(it) }
            binding.btnStart.isVisible=adapterPosition==data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}
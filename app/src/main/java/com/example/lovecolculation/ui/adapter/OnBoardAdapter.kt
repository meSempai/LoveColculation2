package com.example.lovecolculation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

import com.example.lovecolculation.ui.OnBoard
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.ItemOnBoardBinding

class OnBoardAdapter(private val onStartClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.delivery
        ),
        OnBoard(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.cart
        ),
        OnBoard(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.raw.edalatipour
        ),
        OnBoard(
            "It's Funs and Many more", "",
            R.raw.tiktok
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.apply {
                onBoard.image.let { imgBoard.setAnimation(it) }
                tvTittle.text = onBoard.title
                tvDescription.text = onBoard.desc
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }
}
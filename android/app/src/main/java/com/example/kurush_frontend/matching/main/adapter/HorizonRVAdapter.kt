package com.example.kurush_frontend.matching.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kurush_frontend.data.HorizonData
import com.example.kurush_frontend.databinding.ItemMatchingListHorizonBinding

class HorizonRVAdapter(val items : ArrayList<HorizonData>) : RecyclerView.Adapter<HorizonRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMatchingListHorizonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: HorizonData) {
            binding.tvItemMatchingListHorizonNickname.text = item.nickname
            binding.tvItemMatchingListHorizonDepartment.text = item.department
            binding.tvItemMatchingListHorizonCountry.text = item.country
            binding.tvItemMatchingListHorizonGender.text = item.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizonRVAdapter.ViewHolder {
        val binding = ItemMatchingListHorizonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizonRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
package com.example.kurush_frontend.matching.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kurush_frontend.data.VerticalData
import com.example.kurush_frontend.databinding.ItemMatchingListVerticalBinding

class VerticalRVAdapter(val items: ArrayList<VerticalData>) : RecyclerView.Adapter<VerticalRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMatchingListVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : VerticalData) {
            binding.tvItemMatchingListVerticalNickname.text = item.nickname
            binding.tvItemMatchingListVerticalTitle.text = item.title
            binding.tvItemMatchingListHorizonContents.text = item.contents
            binding.tvItemMatchingListHorizonReply.text = item.replies.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerticalRVAdapter.ViewHolder {
        val binding = ItemMatchingListVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerticalRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
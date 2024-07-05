package com.example.kurush_frontend.matching.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kurush_frontend.data.VerticalData
import com.example.kurush_frontend.data.response.PostData
import com.example.kurush_frontend.databinding.ItemMatchingListVerticalBinding

class VerticalRVAdapter(val items: List<PostData>) : RecyclerView.Adapter<VerticalRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMatchingListVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : PostData) {
            binding.tvItemMatchingListVerticalNickname.text = item.nickname
            binding.tvItemMatchingListVerticalTitle.text = item.title
            binding.tvItemMatchingListHorizonContents.text = item.content
            binding.tvItemMatchingListHorizonReply.text = "0"
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
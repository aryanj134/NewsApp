package com.example.mynewsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapp.Data.News
import com.example.mynewsapp.Data.NewsItem
import com.example.mynewsapp.databinding.ItemListBinding

class NewsAdapter(private var newsItemList: List<NewsItem>)
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.listTitle
        val descTextView: TextView = binding.listDesc
        val categoryTextView: TextView = binding.listCategory

        init{
            binding.root.setOnClickListener {
                val position = adapterPosition

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsItemList[position]
        holder.apply {
            titleTextView.text = currentItem.title
            descTextView.text = currentItem.desc
            categoryTextView.text = currentItem.category

        }
    }

    override fun getItemCount() = newsItemList.size

    fun updateData(newNewsItemList: List<NewsItem>) {
        newsItemList = newNewsItemList
        notifyDataSetChanged()
    }
}
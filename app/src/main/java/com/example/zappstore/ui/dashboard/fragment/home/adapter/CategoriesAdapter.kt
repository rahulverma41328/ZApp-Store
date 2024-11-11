package com.example.zappstore.ui.dashboard.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zappstore.databinding.HomeCategoriesCardBinding
import com.example.zappstore.model.HomeCategoriesModel

class CategoriesAdapter(
    private val context: Context,
    private val list: List<HomeCategoriesModel>
): RecyclerView.Adapter<CategoriesAdapter.CategoriesItemViewHolder>() {

    inner class CategoriesItemViewHolder( val binding: HomeCategoriesCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesItemViewHolder {
        val binding = HomeCategoriesCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoriesItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: CategoriesItemViewHolder, position: Int) {
       holder.binding.categoryImage.setBackgroundResource(list[position].imgUrl)
        holder.binding.categoryName.text = list[position].title
    }
}
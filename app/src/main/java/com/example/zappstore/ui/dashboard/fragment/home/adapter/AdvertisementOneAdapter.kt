package com.example.zappstore.ui.dashboard.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zappstore.databinding.AdvertisementOneCardBinding
import com.example.zappstore.model.AdvertisementOneModel

class AdvertisementOneAdapter(
    var context: Context,
    private val list: List<AdvertisementOneModel>
) : RecyclerView.Adapter<AdvertisementOneAdapter.AdvertisementViewHolder>() {

    inner class AdvertisementViewHolder(private val binding: AdvertisementOneCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        val binding = AdvertisementOneCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdvertisementViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {

    }
}
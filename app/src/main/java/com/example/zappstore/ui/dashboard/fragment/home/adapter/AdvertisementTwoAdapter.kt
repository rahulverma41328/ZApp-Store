package com.example.zappstore.ui.dashboard.fragment.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zappstore.databinding.AdvertisementTwoCardBinding
import com.example.zappstore.model.AdvertisementOneModel
import com.example.zappstore.model.AdvertisementTwoModel

class AdvertisementTwoAdapter(
    private var context: Context,
    private val list: List<AdvertisementTwoModel>
) : RecyclerView.Adapter<AdvertisementTwoAdapter.AdvertisementViewHolder>() {

    inner class AdvertisementViewHolder(private val binding: AdvertisementTwoCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisementViewHolder {
        val binding = AdvertisementTwoCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return AdvertisementViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdvertisementViewHolder, position: Int) {

    }
}
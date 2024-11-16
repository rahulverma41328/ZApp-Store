package com.example.zappstore.ui.dashboard.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentHomeBinding
import com.example.zappstore.model.getCategoriesListItem
import com.example.zappstore.model.getOneListItem
import com.example.zappstore.model.getTwoListItem
import com.example.zappstore.ui.dashboard.fragment.home.adapter.AdvertisementOneAdapter
import com.example.zappstore.ui.dashboard.fragment.home.adapter.AdvertisementTwoAdapter
import com.example.zappstore.ui.dashboard.fragment.home.adapter.CategoriesAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdvertisementOne()
        setupAdvertisementTwo()
        setupCategories()
    }

    private fun setupCategories() {
        val adapter = CategoriesAdapter(requireContext(), getCategoriesListItem())
        binding.categories.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.categories.adapter = adapter
    }

    private fun setupAdvertisementTwo() {
        val adapter = AdvertisementTwoAdapter(requireContext(), getTwoListItem())
        binding.advertisementTwo.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.advertisementTwo.adapter = adapter
    }

    private fun setupAdvertisementOne() {
        val adapter = AdvertisementOneAdapter(requireContext(), getOneListItem())
        binding.advertisementOne.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.advertisementOne.adapter = adapter
    }
}
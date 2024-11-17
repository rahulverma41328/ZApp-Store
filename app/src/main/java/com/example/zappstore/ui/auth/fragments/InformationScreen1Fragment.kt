package com.example.zappstore.ui.auth.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentInformationScreen1Binding

class InformationScreen1Fragment: Fragment(R.layout.fragment_information_screen_1) {

    private lateinit var binding: FragmentInformationScreen1Binding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val windowInsetsController = requireActivity().window.insetsController
        //windowInsetsController?.hide(WindowInsets.Type.statusBars())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationScreen1Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivArrow.setOnClickListener {
            findNavController().navigate(R.id.action_informationScreen1Fragment_to_informationScreen2Fragment)
        }
    }
}
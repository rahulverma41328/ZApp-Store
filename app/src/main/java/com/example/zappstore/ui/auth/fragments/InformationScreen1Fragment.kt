package com.example.zappstore.ui.auth.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentInformationScreen1Binding
import com.example.zappstore.ui.auth.fragments.register.viewModel.InformationScreen1ViewModel
import com.example.zappstore.ui.auth.fragments.register.viewModel.InformationScreen1ViewModel.Companion.LOGIN_FRAGMENT
import com.example.zappstore.ui.auth.fragments.register.viewModel.InformationScreen1ViewModel.Companion.SHOPPING_ACTIVITY
import com.example.zappstore.ui.dashboard.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationScreen1Fragment: Fragment(R.layout.fragment_information_screen_1) {

    private lateinit var binding: FragmentInformationScreen1Binding
    private val viewModel by viewModels<InformationScreen1ViewModel>()

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
            viewModel.startButtonClick()
            findNavController().navigate(R.id.action_informationScreen1Fragment_to_informationScreen2Fragment)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.navigate.collect{
                when(it){
                    SHOPPING_ACTIVITY -> {
                        Intent(requireContext(),MainActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                    }
                    LOGIN_FRAGMENT ->{
                        findNavController().navigate(R.id.action_informationScreen1Fragment_to_informationScreen2Fragment)
                    }
                    else -> Unit
                }
            }
        }

    }
}
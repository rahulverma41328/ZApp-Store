package com.example.zappstore.ui.auth.fragments.register

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zappstore.ui.dashboard.MainActivity
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentRegisterScreenBinding

class RegisterScreenFragment: Fragment(R.layout.fragment_register_screen) {

    private lateinit var binding: FragmentRegisterScreenBinding
    private var role: String = "user"

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windowInsetsController = requireActivity().window.insetsController
        windowInsetsController?.hide(WindowInsets.Type.statusBars())

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorPurple = ContextCompat.getColor(requireContext(),R.color.purple)
        val colorWhite = ContextCompat.getColor(requireContext(),R.color.app_bg_white)

        binding.btnRegister.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        binding.tvLogin.setOnClickListener{
            findNavController().navigate(R.id.action_registerScreenFragment_to_loginScreenFragment)
        }

        binding.apply {
            ivServiceProvider.setOnClickListener {
                ivServiceProvider.backgroundTintList = ColorStateList.valueOf(colorPurple)
                ivServiceUser.backgroundTintList = ColorStateList.valueOf(colorWhite)
                role = "service"
            }
        }

        binding.apply {
            ivServiceUser.setOnClickListener {
                ivServiceProvider.backgroundTintList = ColorStateList.valueOf(colorWhite)
                ivServiceUser.backgroundTintList = ColorStateList.valueOf(colorPurple)
                role = "user"
            }
        }
    }

}
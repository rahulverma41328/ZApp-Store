package com.example.zappstore.ui.auth.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zappstore.MainActivity
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentRegisterScreenBinding

class RegisterScreenFragment: Fragment(R.layout.fragment_register_screen) {

    private lateinit var binding: FragmentRegisterScreenBinding

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

        binding.btnRegister.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        binding.tvLogin.setOnClickListener{
            findNavController().navigate(R.id.action_registerScreenFragment_to_loginScreenFragment)
        }
    }

}
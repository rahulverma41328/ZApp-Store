package com.example.zappstore.ui.auth.fragments.register

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.zappstore.ui.dashboard.MainActivity
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentRegisterScreenBinding
import com.example.zappstore.model.User
import com.example.zappstore.ui.auth.fragments.register.viewModel.RegisterViewModel
import com.example.zappstore.util.RegisterValidation
import com.example.zappstore.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class RegisterScreenFragment: Fragment(R.layout.fragment_register_screen) {

    private lateinit var binding: FragmentRegisterScreenBinding
    private val viewModel by viewModels<RegisterViewModel>()
    private var role: String = "user"

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
        binding = FragmentRegisterScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorPurple = ContextCompat.getColor(requireContext(),R.color.purple)
        val colorWhite = ContextCompat.getColor(requireContext(),R.color.app_bg_white)

        binding.apply {
            btnRegister.setOnClickListener {

                val user = User(
                    edName.text.toString().trim(),
                    edEmail.text.toString().trim(),
                    edPhoneNo.text.toString().trim(),
                    role,
                    "unverified"
                )
                val password = edPassword.text.toString()
                viewModel.createAccountWithEmailAndPassword(user,password)

            }
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

        lifecycleScope.launchWhenStarted {
            viewModel.validation.collect{ validate ->
                if (validate.email is RegisterValidation.Failed){
                    withContext(Dispatchers.Main){
                        binding.edEmail.apply {
                            requestFocus()
                            error = validate.email.message
                        }
                    }
                }

                if (validate.password is RegisterValidation.Failed){
                    withContext(Dispatchers.Main){
                        binding.edPassword.apply {
                            requestFocus()
                            error = validate.password.message
                        }
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it){
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        Log.d("test",it.data.toString())
                        Intent(requireActivity(),MainActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                    Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                    }
                    is Resource.Error -> {
                        Log.e("test",it.message.toString())
                    }
                    else -> Unit
                }
            }
        }
    }

}
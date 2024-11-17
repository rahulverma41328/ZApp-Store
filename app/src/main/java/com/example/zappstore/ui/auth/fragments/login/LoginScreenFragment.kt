package com.example.zappstore.ui.auth.fragments.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.zappstore.ui.dashboard.MainActivity
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentLoginScreenBinding
import com.example.zappstore.dialog.setupBottomSheetDialog
import com.example.zappstore.ui.auth.fragments.login.viewModel.LoginViewModel
import com.example.zappstore.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreenFragment: Fragment(R.layout.fragment_login_screen) {

    private lateinit var binding: FragmentLoginScreenBinding
    private val viewModel by viewModels<LoginViewModel>()

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
    ): View {
        binding = FragmentLoginScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginScreenFragment_to_registerScreenFragment)
        }

        binding.apply {
            btnLogin.setOnClickListener {
                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                val email = edEmail.text.toString().trim()
                val password = edPassword.text.toString()
                viewModel.login(email,password)
            }
        }

        binding.apply {
            tvForgetPassword.setOnClickListener {
                setupBottomSheetDialog { email ->
                    viewModel.resetPassword(email)
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.login.collect{
                when(it){
                    is Resource.Loading ->{
                        //binding.buttonLoginLogin.startAnimation()
                    }
                    is Resource.Success ->{
                        Intent(requireActivity(),MainActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                    Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                        //binding.buttonLoginLogin.revertAnimation()
                    }
                    is Resource.Error ->{
                      //  binding.buttonLoginLogin.revertAnimation()
                        Toast.makeText(requireContext(),it.message.toString(), Toast.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.resetPassword.collect{
                when(it){
                    is Resource.Loading ->{

                    }
                    is Resource.Success ->{
                        Snackbar.make(requireView(),"Reset link was sent to your email", Snackbar.LENGTH_LONG).show()
                    }
                    is Resource.Error ->{
                        Snackbar.make(requireView(),it.message.toString(), Snackbar.LENGTH_LONG).show()
                    }
                    else -> Unit
                }
            }
        }
    }
}
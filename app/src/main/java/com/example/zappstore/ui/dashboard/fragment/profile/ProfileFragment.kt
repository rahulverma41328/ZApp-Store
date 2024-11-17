package com.example.zappstore.ui.dashboard.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.zappstore.R
import com.example.zappstore.databinding.FragmentProfileBinding
import com.example.zappstore.model.User
import com.example.zappstore.ui.dashboard.fragment.profile.viewModel.ProfileViewModel
import com.example.zappstore.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.getUser.collect{
                when(it){
                        is Resource.Loading ->{
                            // to do
                        }
                        is Resource.Success ->{
                            val data = it.data
                            val user = data?.get(0)

                            binding.apply {
                                edUserName.setText(user?.name)
                                edUserEmail.setText(user?.email)
                                edUserPhoneNo.setText(user?.phoneNo)
                            }
                        }
                        is Resource.Error ->{

                        }
                        else -> Unit
                }
            }
        }
    }
}
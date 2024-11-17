package com.example.zappstore.ui.auth.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zappstore.R

class WelcomeScreenFragment: Fragment(R.layout.fragment_welcome_screen) {

    private val handler = Handler(Looper.getMainLooper())
    private val SPLASH_TIMER: Long = 3000

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val runnable = Runnable {

            findNavController().navigate(R.id.action_welcomeScreenFragment_to_informationScreen1Fragment)

        }
        handler.postDelayed(runnable,SPLASH_TIMER)
    }
}
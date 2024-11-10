package com.example.zappstore.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.zappstore.R
import com.example.zappstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val controller = findNavController(R.id.dashboardHostFragment)
        binding.bottomNavigation.setupWithNavController(controller)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when( it.itemId){
                R.id.homeFragment -> binding.tvTitle.text = "ZAppStore"
                R.id.chatFragment -> binding.tvTitle.text = "Chat"
                R.id.ordersFragment -> binding.tvTitle.text = "Orders"
                R.id.profileFragment -> binding.tvTitle.text = "Profile"
            }
            true
        }

    }
}
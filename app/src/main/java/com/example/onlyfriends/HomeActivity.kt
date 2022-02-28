package com.example.onlyfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlyfriends.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenClick()
    }

    private fun listenClick(){
        binding.connectBtn.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserActivity::class.java)
            startActivity(intent)
        }
    }
}
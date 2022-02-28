package com.example.onlyfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.onlyfriends.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenClick()
    }

    private fun listenClick(){
        binding.connectBtn.setOnClickListener {
            val intent = Intent(this@LandingActivity, UserActivity::class.java)
            startActivity(intent)
        }
    }
}
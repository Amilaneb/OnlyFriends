package com.example.onlyfriends

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlyfriends.Navigation.AccountFragment
import com.example.onlyfriends.Navigation.HomeFragment
import com.example.onlyfriends.Navigation.SearchFragment
import com.example.onlyfriends.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
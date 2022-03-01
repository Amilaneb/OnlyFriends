package com.example.onlyfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlyfriends.Navigation.AccountFragment
import com.example.onlyfriends.Navigation.HomeFragment
import com.example.onlyfriends.Navigation.SearchFragment
import com.example.onlyfriends.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavigateTo()
    }

    private fun NavigateTo(){
        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val accountFragment =  AccountFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, homeFragment).commit()
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit()
                    true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, searchFragment).commit()
                    true
                }
                R.id.account -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, accountFragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}
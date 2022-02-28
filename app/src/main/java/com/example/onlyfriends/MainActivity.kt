package com.example.onlyfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.onlyfriends.Authentification.LoginFragment
import com.example.onlyfriends.Authentification.RegisterFragment
import com.example.onlyfriends.Navigation.AccountFragment
import com.example.onlyfriends.Navigation.AddFragment
import com.example.onlyfriends.Navigation.HomeFragment
import com.example.onlyfriends.Navigation.SearchFragment
import com.example.onlyfriends.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavigateTo()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val addFragment = AddFragment()
        when (item.itemId) {
            R.id.add -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, addFragment).commit()
                true
            }
        }
        return super.onOptionsItemSelected(item)
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
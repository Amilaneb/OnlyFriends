package com.example.onlyfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlyfriends.databinding.ActivityHomeBinding

interface LoginActivityFragmentInteraction {


    fun showConnect()
    fun showRegister()
}

class HomeActivity : AppCompatActivity(), LoginActivityFragmentInteraction {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
    }

    override fun showConnect() {
        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, loginFragment)
            .commit()
    }

    override fun showRegister() {
        val registerFragment = RegisterFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, registerFragment)
            .commit()
        }
}
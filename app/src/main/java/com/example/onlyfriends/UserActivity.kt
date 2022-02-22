package com.example.onlyfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlyfriends.databinding.ActivityUserBinding

interface LoginActivityFragmentInteraction{
    fun showLogin()
    fun showRegister()
}

class UserActivity : AppCompatActivity(),  LoginActivityFragmentInteraction {
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
    }

    override fun showLogin() {
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
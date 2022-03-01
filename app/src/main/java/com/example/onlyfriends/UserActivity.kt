package com.example.onlyfriends

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlyfriends.Authentification.LoginFragment
import com.example.onlyfriends.Authentification.RegisterFragment
import com.example.onlyfriends.databinding.ActivityUserBinding
import com.google.firebase.FirebaseApp

import com.google.firebase.FirebaseOptions
import java.io.FileInputStream


interface UserActivityFragmentInteraction{
    fun showLogin()
    fun showRegister()
    fun makeRequest(email:String?, password: String?, firstName: String?, lastName: String?, isFromLogin: Boolean)
}

class UserActivity : AppCompatActivity(),  UserActivityFragmentInteraction {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fragment = LoginFragment()
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

    override fun makeRequest(
        email: String?,
        password: String?,
        firstName: String?,
        lastName: String?,
        isFromLogin: Boolean
    ) {
        if (verifyInformation(email, password, firstName, lastName, isFromLogin)) {
            Toast.makeText(this, getString(R.string.validForm), Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, getString(R.string.invalidForm), Toast.LENGTH_LONG).show()
        }
    }
    private fun verifyInformation(
        email: String?,
        password: String?,
        firstName: String?,
        lastName: String?,
        isFromLogin: Boolean
    ): Boolean {
        var verified = (email?.isNotEmpty() == true && password?.count() ?: 0 >= 6)
        if (!isFromLogin) {
            verified =
                verified && (firstName?.isNotEmpty() == true && lastName?.isNotEmpty() == true)
        }
        return verified
    }

}
package com.example.onlyfriends

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.onlyfriends.databinding.ActivityUserBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

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
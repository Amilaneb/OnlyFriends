package com.example.onlyfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import com.example.onlyfriends.Navigation.AccountFragment
import com.example.onlyfriends.Navigation.HomeFragment
import com.example.onlyfriends.Navigation.SearchFragment
import com.example.onlyfriends.databinding.ActivityMainBinding


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
        return when(item.itemId){
            R.id.camera -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 10)
                true
                return true
            }
            R.id.gallery -> {
                chooseImageGallery()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
    private fun chooseImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_CHOOSE)
    }

    companion object {
        private val IMAGE_CHOOSE = 1000;
    }
}
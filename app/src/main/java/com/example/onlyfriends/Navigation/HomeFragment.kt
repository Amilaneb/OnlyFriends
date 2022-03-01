package com.example.onlyfriends.Navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlyfriends.UserActivity
import com.example.onlyfriends.UserActivityFragmentInteraction
import com.example.onlyfriends.databinding.FragmentHomeBinding
import com.example.onlyfriends.databinding.FragmentLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonsignOut.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(requireActivity(), UserActivity::class.java))
        }
    }
}
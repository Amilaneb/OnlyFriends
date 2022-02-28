package com.example.onlyfriends

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.onlyfriends.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth;
    var interactor: LoginActivityFragmentInteraction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if(currentUser != null){
            Toast.makeText(requireActivity(),"You Signed In successfully",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(requireActivity(),"You Didnt signed in",Toast.LENGTH_LONG).show();
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as? LoginActivityFragmentInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noAccountBtn.setOnClickListener {
            interactor?.showRegister()
        }
    }
}
package com.example.onlyfriends.Authentification

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.onlyfriends.MainActivity
import com.example.onlyfriends.UserActivityFragmentInteraction
import com.example.onlyfriends.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    var interactor: UserActivityFragmentInteraction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI(currentUser)
        }
    }
    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            Toast.makeText(requireActivity(), "You Signed In successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        } else {
            Toast.makeText(requireActivity(), "You Didn't signed in", Toast.LENGTH_LONG).show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as? UserActivityFragmentInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.alreadyBtn.setOnClickListener {
            interactor?.showLogin()
        }
        binding.validateBtn.setOnClickListener{
            interactor?.makeRequest(
                binding.email.text.toString(),
                binding.password.text.toString(),
                null,
                null,
                true
            )
            auth.createUserWithEmailAndPassword(binding.email.text.toString().trim(), binding.password.text.toString().trim())
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("create", "createUserWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("create", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(requireActivity(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }
    }
}
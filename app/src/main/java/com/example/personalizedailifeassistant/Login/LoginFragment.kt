package com.example.personalizedailifeassistant.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.DashboardFrag
import com.example.personalizedailifeassistant.R
import com.example.personalizedailifeassistant.Register.RegisterFragment

class LoginFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val emailEditText = view.findViewById<EditText>(R.id.etEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.etPassword)
        val loginButton = view.findViewById<Button>(R.id.btnLogin)
        val registerButton = view.findViewById<Button>(R.id.btnRegister)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Login clicked with email: $email", Toast.LENGTH_SHORT).show()
                // Add your login logic here
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DashboardFragment())
                    .addToBackStack(null) // allows back navigation
                    .commit()
            }
        }
        registerButton.setOnClickListener {
            // Replace with RegisterFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment())
                .addToBackStack(null) // allows back navigation
                .commit()
        }
    }
}
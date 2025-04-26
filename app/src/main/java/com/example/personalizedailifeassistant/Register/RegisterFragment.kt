package com.example.personalizedailifeassistant.Register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class RegisterFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val emailEditText = view.findViewById<EditText>(R.id.etRegisterEmail)
        val passwordEditText = view.findViewById<EditText>(R.id.etRegisterPassword)
        val confirmPasswordEditText = view.findViewById<EditText>(R.id.etRegisterConfirmPassword)
        val registerButton = view.findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Handle registration logic here
                Toast.makeText(requireContext(), "Registered with email: $email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
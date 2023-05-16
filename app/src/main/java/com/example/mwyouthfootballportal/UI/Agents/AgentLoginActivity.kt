package com.example.mwyouthfootballportal.UI.Agents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mwyouthfootballportal.R
import com.example.mwyouthfootballportal.databinding.ActivityAgentSignupBinding
import com.example.mwyouthfootballportal.databinding.AgentloginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AgentLoginActivity : AppCompatActivity() {

    lateinit var binding: AgentloginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AgentloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        binding.agentLoginButton.setOnClickListener {
            loginAgent()
        }
        
    }

    fun loginAgent() {
        val email = binding.agentLoginEmail.text.toString()
        val password = binding.agentLoginPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    navigateToAgentActivity()
                } else {
                    binding.loginMessage.text = "Login failed, please try again"
                }
            }
    }

    private fun checkCurrentUser() {
        val currentUser: FirebaseUser? = auth.currentUser
        if(currentUser != null) {
            navigateToAgentActivity()
        }
    }

    private fun navigateToAgentActivity() {
        val intent = Intent(this, AgentActivity::class.java)
        startActivity(intent)
        finish()
    }
}
package com.example.mwyouthfootballportal.UI.Fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mwyouthfootballportal.R
import com.example.mwyouthfootballportal.UI.Agents.AgentLoginActivity
import com.example.mwyouthfootballportal.UI.Agents.AgentSignupActivity
import com.example.mwyouthfootballportal.databinding.FragmentAgentBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import java.util.Calendar

class AgentFragment : Fragment() {

    lateinit var binding: FragmentAgentBinding
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentBinding.inflate(inflater, container, false)

        binding.agentSignup.setOnClickListener {
            val intent = Intent(this@AgentFragment.requireContext(),
                AgentSignupActivity::class.java)
            startActivity(intent)
        }

        binding.agentLogin.setOnClickListener {
            val intent = Intent(this@AgentFragment.requireContext(),
                AgentLoginActivity::class.java)
            startActivity(intent)
        }

        val currentDate = Calendar.getInstance()

        return binding.root
        //return inflater.inflate(R.layout.fragment_agent, container, false)
    }



}
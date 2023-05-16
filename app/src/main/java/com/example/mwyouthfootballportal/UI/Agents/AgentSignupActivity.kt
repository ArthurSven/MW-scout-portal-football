package com.example.mwyouthfootballportal.UI.Agents

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mwyouthfootballportal.Data.Models.Agent
import com.example.mwyouthfootballportal.databinding.ActivityAgentSignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class AgentSignupActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAgentSignupBinding
    private lateinit var dbReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        binding = ActivityAgentSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Firebase.database.reference

        binding.agentSignupButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val firstname = binding.agentfirstname.text.toString()
        val surname = binding.agentsurname.text.toString()
        val email = binding.agentEmail.text.toString()
        val username = binding.agentUsername.text.toString()
        val password = binding.agentPassword.text.toString()
        val confirmPassword = binding.agentComfirmPassword.text.toString()

        database = FirebaseDatabase.getInstance("https://mw-youth-football-portal-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Agents")

        val agent = Agent(firstname, surname, email, username)
        database.child(username).setValue(agent).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                binding.agentfirstname.text?.clear()
                binding.agentsurname.text?.clear()
                binding.agentEmail.text?.clear()
                binding.agentUsername.text?.clear()
                binding.agentPassword.text?.clear()
                binding.agentComfirmPassword.text?.clear()

                if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword == password) {
                    CoroutineScope(Dispatchers.IO).launch {
                        try{
                            auth.createUserWithEmailAndPassword(email, password).await()
                            withContext(Dispatchers.Main) {
                                checkedState()
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(this@AgentSignupActivity, e.message, Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                }

                Toast.makeText(this, "Agent account successfully created", Toast.LENGTH_LONG)
                    .show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Agent account failed to create", Toast.LENGTH_LONG)
                .show()
        }


    }

    /*private fun authenticateAgent() {
        val email = binding.agentEmail.text.toString()
        val password = binding.agentPassword.text.toString()
        val confirmPassword = binding.agentComfirmPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword == password) {
            CoroutineScope(Dispatchers.IO).launch {
                try{
                    auth.createUserWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main) {
                        checkedState()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AgentSignupActivity, e.message, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }*/

    private fun checkedState() {
       if (auth.currentUser == null) {
           Toast.makeText(this, "You are not logged in", Toast.LENGTH_LONG).show()
       }
        else {
            Toast.makeText(this, "You are logged in", Toast.LENGTH_SHORT).show()
        }
    }


}
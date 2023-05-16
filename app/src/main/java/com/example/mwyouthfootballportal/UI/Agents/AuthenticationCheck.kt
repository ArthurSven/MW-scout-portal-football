package com.example.mwyouthfootballportal.UI.Agents

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationCheck(private val context: Context) {

    private val authentic: FirebaseAuth = FirebaseAuth.getInstance()

    fun checkUserSession() {
        val currentUser: FirebaseUser? = authentic.currentUser
        if (currentUser != null) {
            Toast.makeText(context, "Welcome!", Toast.LENGTH_SHORT).show()
        } else {
                val intent = Intent(context, AgentLoginActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }
}
package com.example.mwyouthfootballportal.UI.Agents

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.mwyouthfootballportal.R
import com.example.mwyouthfootballportal.databinding.ActivityAgentBinding

class AgentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentBinding
    private lateinit var authCheck: AuthenticationCheck
    private lateinit var drawerToggle: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authCheck = AuthenticationCheck(this)
        authCheck.checkUserSession()

        drawerToggle = binding.navIcon

        drawerToggle.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    fun setCurrent(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.agentFrame, fragment)
                .commit()
        }
        return true
    }
}
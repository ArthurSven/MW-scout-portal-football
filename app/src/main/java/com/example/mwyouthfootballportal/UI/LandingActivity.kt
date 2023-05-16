package com.example.mwyouthfootballportal.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mwyouthfootballportal.R
import com.example.mwyouthfootballportal.UI.Fragments.AgentFragment
import com.example.mwyouthfootballportal.UI.Fragments.HomeFragment
import com.example.mwyouthfootballportal.UI.Fragments.TeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottomNavigationView)

        //initialising fragments
        val homeFragment = HomeFragment()
        val agentFragment = AgentFragment()
        val teamFragment = TeamFragment()

        //setting default fragment
        setFragment(homeFragment)

        //Setting bottom navigation to display different fragments when menu items are clciked
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setFragment(homeFragment)
                R.id.agent -> setFragment(agentFragment)
                R.id.team -> setFragment(teamFragment)
            }
            true
        }


    }

    //method to set fragment
    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fLayout, fragment)
            commit()
        }
    }
}
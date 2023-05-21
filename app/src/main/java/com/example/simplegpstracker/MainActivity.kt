package com.example.simplegpstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplegpstracker.databinding.ActivityMainBinding
import com.example.simplegpstracker.fragments.MainFragment
import com.example.simplegpstracker.fragments.SettingsFragment
import com.example.simplegpstracker.fragments.TracksFragment
import com.example.simplegpstracker.utils.openFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClick()
        openFragment(MainFragment.newInstance())
    }

    private fun onBottomNavClick() {
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.id_home -> {
                    openFragment(MainFragment.newInstance())
                }
                R.id.id_tracks -> {
                    openFragment(TracksFragment.newInstance())
                }
                R.id.id_settings -> {
                    openFragment(SettingsFragment())
                }
            }
            true
        }
    }
}
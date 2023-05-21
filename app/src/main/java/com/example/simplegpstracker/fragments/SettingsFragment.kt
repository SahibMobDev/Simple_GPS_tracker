package com.example.simplegpstracker.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.simplegpstracker.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main_preference, rootKey)
    }

}
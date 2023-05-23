package com.example.simplegpstracker.fragments

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.simplegpstracker.R
import com.example.simplegpstracker.utils.showToast

class SettingsFragment : PreferenceFragmentCompat() {
    lateinit var timePref: Preference
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main_preference, rootKey)
        init()
    }

    private fun init() {
        timePref = findPreference("update_time_key")!!
        val changeListener = onChangedListener()
        timePref.onPreferenceChangeListener = changeListener
    }

    private fun onChangedListener() : Preference.OnPreferenceChangeListener {
        return Preference.OnPreferenceChangeListener {
            pref, value ->
            val nameArray = resources.getStringArray(R.array.loc_time_update_name)
            val valueArray = resources.getStringArray(R.array.loc_time_update_value)
            val title = pref.title.toString().substringBefore(":")
            pref.title = "$title: ${nameArray[valueArray.indexOf(value)]}"

            true
        }
    }

}
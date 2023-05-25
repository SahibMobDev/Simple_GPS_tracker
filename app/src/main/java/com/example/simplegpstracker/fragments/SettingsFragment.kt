package com.example.simplegpstracker.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.simplegpstracker.R

class SettingsFragment : PreferenceFragmentCompat() {
    lateinit var timePref: Preference
    lateinit var colorPref: Preference
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main_preference, rootKey)
        init()
    }

    private fun init() {
        timePref = findPreference("update_time_key")!!
        colorPref = findPreference("color_key")!!
        val changeListener = onChangedListener()
        timePref.onPreferenceChangeListener = changeListener
        colorPref.onPreferenceChangeListener = changeListener
        initPref()
    }

    private fun onChangedListener() : Preference.OnPreferenceChangeListener {
        return Preference.OnPreferenceChangeListener {
            pref, value ->
            when(pref.key) {
                "update_time_key" -> onTimeChange(value.toString())
                "color_key" -> colorPref.icon?.setTint(Color.parseColor(value.toString()))
            }
            true
        }
    }

    private fun onTimeChange(value: String) {
        val nameArray = resources.getStringArray(R.array.loc_time_update_name)
        val valueArray = resources.getStringArray(R.array.loc_time_update_value)
        val title = timePref.title.toString().substringBefore(":")
        timePref.title = "$title: ${nameArray[valueArray.indexOf(value)]}"
    }

    private fun initPref() {
        val pref = timePref.preferenceManager.sharedPreferences
        val nameArray = resources.getStringArray(R.array.loc_time_update_name)
        val valueArray = resources.getStringArray(R.array.loc_time_update_value)
        val title = timePref.title
        val pos = valueArray.indexOf(pref?.getString("update_time_key", "3000"))
        timePref.title = "$title: ${nameArray[pos]}"

        val trackColor = pref?.getString("color_key", "#278EA7")
        colorPref.icon?.setTint(Color.parseColor(trackColor))
    }

}
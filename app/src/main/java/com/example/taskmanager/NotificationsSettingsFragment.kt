package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment

class NotificationsSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.notifications_settings_fragment, container, false)

        val emailSwitch: Switch = view.findViewById(R.id.emailSwitch)
        val emailInput: EditText = view.findViewById(R.id.emailInput)
        val smsSwitch: Switch = view.findViewById(R.id.smsSwitch)
        val phoneInput: EditText = view.findViewById(R.id.phoneInput)
        val saveButton: Button = view.findViewById(R.id.saveSettingsButton)

        saveButton.setOnClickListener {
            if (emailSwitch.isChecked && emailInput.text.toString().isNotEmpty()) {
                Toast.makeText(context, "Email notifications enabled for ${emailInput.text}", Toast.LENGTH_SHORT).show()
            }
            if (smsSwitch.isChecked && phoneInput.text.toString().isNotEmpty()) {
                Toast.makeText(context, "SMS notifications enabled for ${phoneInput.text}", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
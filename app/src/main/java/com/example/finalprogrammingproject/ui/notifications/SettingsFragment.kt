package com.example.finalprogrammingproject.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalprogrammingproject.MainActivity
import com.example.finalprogrammingproject.R
import com.example.finalprogrammingproject.databinding.FragmentSettingsBinding
import com.example.finalprogrammingproject.ui.PopupAccountActivity
import com.example.finalprogrammingproject.ui.PopupBlockedActivity
import com.example.finalprogrammingproject.ui.PopupFilterActivity
import com.example.finalprogrammingproject.ui.PopupHelpActivity

class SettingsFragment : Fragment() {

    private lateinit var filterButton: Button
    private lateinit var accountButton: Button
    private lateinit var blockedButton: Button
    private lateinit var helpButton: Button

    private lateinit var notificationsViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProvider(this).get(SettingsViewModel::class.java)


        filterButton = view.findViewById<Button>(R.id.filterButton)
        filterButton.setOnClickListener {
            val intent = Intent(context, PopupFilterActivity::class.java)
            startActivity(intent)
        }

        accountButton = view.findViewById<Button>(R.id.accountButton)
        accountButton.setOnClickListener {
            val intent = Intent(context, PopupAccountActivity::class.java)
            startActivity(intent)
        }

        blockedButton = view.findViewById<Button>(R.id.blockedButton)
        blockedButton.setOnClickListener {
            val intent = Intent(context, PopupBlockedActivity::class.java)
            startActivity(intent)
        }

        helpButton = view.findViewById<Button>(R.id.helpButton)
        helpButton.setOnClickListener {
            val intent = Intent(context, PopupHelpActivity::class.java)
            startActivity(intent)
        }

    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
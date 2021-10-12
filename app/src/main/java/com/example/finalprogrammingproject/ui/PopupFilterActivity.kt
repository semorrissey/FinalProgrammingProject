package com.example.finalprogrammingproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.finalprogrammingproject.R
import com.example.finalprogrammingproject.ui.notifications.SettingsFragment
import com.example.finalprogrammingproject.ui.notifications.SettingsViewModel

class PopupFilterActivity : AppCompatActivity() {

    private lateinit var filterFinished: Button

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.filter_popup)

        super.onCreate(savedInstanceState)
        ViewModelProvider(this).get(SettingsViewModel::class.java)


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        var displayWidth = (width * .8).toInt()
        var displayHeight = (width * .6).toInt()


        window.setLayout(displayWidth, displayHeight)

        var actionBar = getSupportActionBar()

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }
}


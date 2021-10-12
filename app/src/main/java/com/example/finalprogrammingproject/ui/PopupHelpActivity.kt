package com.example.finalprogrammingproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.finalprogrammingproject.R
import com.example.finalprogrammingproject.ui.notifications.SettingsFragment
import com.example.finalprogrammingproject.ui.notifications.SettingsViewModel

class PopupHelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.help_popup)


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

package com.example.finalprogrammingproject.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprogrammingproject.R

class PopupAccountActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.account_popup)


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
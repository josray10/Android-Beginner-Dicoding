package com.belajar.android.valorantesportteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class aboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar!!.title = "About"


    }
}
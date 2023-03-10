package com.belajar.android.valorantesportteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailEsportsActivity : AppCompatActivity() {


    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_LOC = "extra_loc"
        const val EXTRA_REG = "extra_reg"
        const val EXTRA_ROSTER = "extra_roster"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_esports)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvLocation: TextView = findViewById(R.id.tv_item_location)
        val tvRegion: TextView = findViewById(R.id.tv_item_region)
        val tvDesc: TextView = findViewById(R.id.tv_item_description)
        val tvRoster: TextView = findViewById(R.id.tv_item_roster)


        val teamLogo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val teamName = intent.getStringExtra(EXTRA_NAME)
        val teamLoc = intent.getStringExtra(EXTRA_LOC)
        val teamReg = intent.getStringExtra(EXTRA_REG)
        val teamDesc = intent.getStringExtra(EXTRA_DESC)
        val teamRoster = intent.getStringExtra(EXTRA_ROSTER)

        imgPhoto.setImageResource(teamLogo)
        tvName.text = teamName
        tvLocation.text = teamLoc
        tvRegion.text = teamReg
        tvDesc.text = teamDesc
        tvRoster.text = teamRoster

        supportActionBar!!.title = tvName.text

    }

    override fun onSupportNavigateUp(): Boolean {
        this.onBackPressed()

        return true
    }


}
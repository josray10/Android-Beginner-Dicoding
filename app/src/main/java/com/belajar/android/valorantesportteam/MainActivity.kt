package com.belajar.android.valorantesportteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    private lateinit var rvEsports: RecyclerView
    private val list = arrayListOf<EsportsTeam>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEsports = findViewById(R.id.rv_esports)
        rvEsports.setHasFixedSize(true)

        list.addAll(getListEsports())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_menu -> {
                val aboutIntent =Intent(this@MainActivity, aboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return true
    }

    private fun getListEsports(): ArrayList<EsportsTeam> {
        val dataName = resources.getStringArray(R.array.data_esports_name)
        val dataLocation = resources.getStringArray(R.array.data_esports_location)
        val dataRegion = resources.getStringArray(R.array.data_esports_region)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDesc = resources.getStringArray(R.array.data_esports_detail)
        val dataRoster = resources.getStringArray(R.array.data_esports_roster)
        val listEsports = ArrayList<EsportsTeam>()
        for (i in dataName.indices){
            val esports = EsportsTeam(dataName[i], dataLocation[i], dataRegion[i], dataDesc[i], dataPhoto.getResourceId(i, -1), dataRoster[i])
            listEsports.add(esports)
        }
        return listEsports
    }


    private fun showRecyclerList() {
        rvEsports.layoutManager = LinearLayoutManager(this)
        val listEsportsAdapter = ListEsportsAdapter(list)
        rvEsports.adapter = listEsportsAdapter
    }
}
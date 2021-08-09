package org.pioneer.pioneerApp.Concert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_concert.*
import org.pioneer.pioneerApp.Adapter.ConcertAdapter
import org.pioneer.pioneerApp.R

class ConcertActivity : AppCompatActivity() {

    val adapter = ConcertAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concert)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager=layoutManager

        adapter.items.add(ConcertModel("OOTD(Online O.T. Day)","2021.02.24","인천대학교 17호관",20210224))
        adapter.items.add(ConcertModel("School of Music","2021.09.17","Club MOMO",20210917))
        recyclerview.adapter=adapter

        adapter.listener = object : onConcertItemClickListener {
            override fun onItemClick(holder: ConcertAdapter.ViewHolder?, view: View?, position: Int) {
                val item = adapter.items[position]
                val requestcode = item.requestcode
                memberIntent(requestcode)
            }
        }
    }
    fun memberIntent(requestcode:Int){
        val musiclistintent = Intent(this, SetlistActivity::class.java)
        musiclistintent.putExtra("requestcode",requestcode)
        startActivity(musiclistintent)
    }
}
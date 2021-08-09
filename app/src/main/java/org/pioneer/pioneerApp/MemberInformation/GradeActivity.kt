package org.pioneer.pioneerApp.MemberInformation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.pioneer.pioneerApp.Adapter.GradeAdapter
import org.pioneer.pioneerApp.R
import kotlinx.android.synthetic.main.activity_grade.*

class GradeActivity : AppCompatActivity() {

    val adapter = GradeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager=layoutManager

        adapter.items.add(GradeModel("43기",43))
        adapter.items.add(GradeModel("42기",42))
        adapter.items.add(GradeModel("41기",41))
        adapter.items.add(GradeModel("40기",40))

        recyclerview.adapter=adapter

        adapter.listener = object : onGradeItemClickListener{
            override fun onItemClick(holder: GradeAdapter.ViewHolder?, view: View?, position: Int) {
                val item = adapter.items[position]
                val requestcode = item.requestcode
                memberIntent(requestcode)
            }
        }
    }
    fun memberIntent(requestcode:Int){
        val memberintent = Intent(this,MemberActivity::class.java)
        memberintent.putExtra("requestcode",requestcode)
        startActivity(memberintent)
    }
}
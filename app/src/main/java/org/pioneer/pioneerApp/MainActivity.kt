package org.pioneer.pioneerApp

import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import org.pioneer.pioneerApp.Adapter.WritingListAdapter
import org.pioneer.pioneerApp.NoticeList.ListActivity
import org.pioneer.pioneerApp.NoticeList.WritingModel
import org.pioneer.pioneerApp.utils.FBRef

class MainActivity : AppCompatActivity() {

    lateinit var RCAdapter : WritingListAdapter

    val List = mutableListOf<WritingModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instagram_icon.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/inu_pioneer/"))
            startActivity(intent)
        }
        youtube_icon.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/UIPIONEER"))
            startActivity(intent)
        }
        facebook_icon.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/inupioneer"))
            startActivity(intent)
        }
        concert_icon.setOnClickListener{

        }

        val moreButton = findViewById<TextView>(R.id.NoticeMore)
        moreButton.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        getData()

        RCAdapter = WritingListAdapter(this, List)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = RCAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        recyclerView.setLayoutManager(linearLayoutManager)

    }
    fun getData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                List.clear()
                for(dataModel in dataSnapshot.children){
                    Log.d(ContentValues.TAG, dataModel.toString())
                    val item = dataModel.getValue(WritingModel::class.java)
                    List.add(item!!)
                }
                RCAdapter.notifyDataSetChanged()


            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.addValueEventListener(postListener)
    }

}
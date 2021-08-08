package org.pioneer.pioneerApp.NoticeList

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import org.pioneer.pioneerApp.Adapter.WritingListAdapter
import org.pioneer.pioneerApp.R
import org.pioneer.pioneerApp.databinding.ActivityListBinding
import org.pioneer.pioneerApp.utils.FBRef


class ListActivity : AppCompatActivity() {


    lateinit var RCAdapter : WritingListAdapter

    private val writingKeyList = mutableListOf<String>()

    val List = mutableListOf<WritingModel>()



    private lateinit var binding : ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        binding.writingBtn.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            startActivity(intent)
        }

        getData()


        RCAdapter = WritingListAdapter(this, List)
        RCAdapter.setItemClickListener(object: WritingListAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(applicationContext, WritingInsideActivity::class.java)
                intent.putExtra("key", writingKeyList[position])
                startActivity(intent)
            }
        })

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
                    Log.d(TAG, dataModel.toString())
                    val item = dataModel.getValue(WritingModel::class.java)
                    List.add(item!!)
                    writingKeyList.add(dataModel.key.toString())
                }
                RCAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.addValueEventListener(postListener)
    }

}


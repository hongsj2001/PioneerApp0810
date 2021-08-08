package org.pioneer.pioneerApp.NoticeList

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import org.pioneer.pioneerApp.R
import org.pioneer.pioneerApp.databinding.ActivityWritingEditBinding
import org.pioneer.pioneerApp.utils.FBRef
import java.lang.Exception

class WritingEditActivity : AppCompatActivity() {

    private lateinit var key: String

    private lateinit var binding : ActivityWritingEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_edit)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_writing_edit)

        key = intent.getStringExtra("key").toString()
        getWritingData(key)
        binding.editButton.setOnClickListener {
            editWritingData(key)
        }
    }

    private fun editWritingData(key: String) {
        FBRef.boardRef.child(key)
            .setValue(WritingModel(binding.editTextTitle.text.toString(), binding.editTextContent.text.toString(), FBRef.getTime()))


        finish()
    }

    fun getWritingData(key : String){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try {
                    val dataModel = dataSnapshot.getValue(WritingModel::class.java)

                    binding.editTextTitle.setText(dataModel!!.title)
                    binding.editTextContent.setText(dataModel!!.content)

                } catch(e : Exception){
                    Log.d(ContentValues.TAG, "삭제완료")
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }
}
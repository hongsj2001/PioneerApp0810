package org.pioneer.pioneerApp.NoticeList

import android.content.ContentValues
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import org.pioneer.pioneerApp.R
import org.pioneer.pioneerApp.databinding.ActivityWritingInsideBinding
import org.pioneer.pioneerApp.utils.FBRef
import java.lang.Exception

class WritingInsideActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWritingInsideBinding

    private lateinit var  key : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_inside)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_writing_inside)

        binding.back.setOnClickListener {
            finish()
        }
        binding.removeBtn.setOnClickListener {
            showDialog()
        }

        key = intent.getStringExtra("key").toString()

        getWritingData(key)
    }

    private fun showDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.remove_dialog, null)
        val mBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)
            .setView(mDialogView)
            .setTitle("게시글을 삭제하시겠습니까?")

        val alertDialog = mBuilder.show()

        alertDialog.findViewById<Button>(R.id.button_remove)?.setOnClickListener {
            FBRef.boardRef.child(key).removeValue()
            finish()
        }
        alertDialog.findViewById<Button>(R.id.button_cancel)?.setOnClickListener {

            alertDialog.dismiss()
        }
    }

    fun getWritingData(key : String){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try {
                    val dataModel = dataSnapshot.getValue(WritingModel::class.java)

                    binding.writingTitle.text = dataModel!!.title
                    binding.writingContent.text = dataModel!!.content
                    binding.writingTime.text = dataModel!!.time

                } catch(e : Exception){
                    Log.d(TAG, "삭제완료")
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }
}
package org.pioneer.pioneerApp.NoticeList

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.pioneer.pioneerApp.R
import org.pioneer.pioneerApp.databinding.ActivityWritingBinding
import org.pioneer.pioneerApp.utils.FBRef

class WritingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWritingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_writing)



        binding.back.setOnClickListener {
            finish()
        }

        binding.writing.setOnClickListener {
            val Title = binding.editTextTitle.text.toString()
            val content = binding.editTextContent.text.toString()
            val time = FBRef.getTime()

            FBRef.boardRef
                .push()
                .setValue(WritingModel(Title, content, time))

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()

            finish()
        }
    }
}
package org.pioneer.pioneerApp.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class FBRef {

    companion object {
        private val database = Firebase.database


        val boardRef = database.getReference("board")

        fun getTime() : String {
            val currentDateTime = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)

            return dateFormat
        }
    }
}
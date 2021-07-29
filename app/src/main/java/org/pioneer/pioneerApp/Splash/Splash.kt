package org.pioneer.pioneerApp.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.pioneer.pioneerApp.MainActivity
import org.pioneer.pioneerApp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this, MainActivity::class.java))

            finish()

        },3000)
    }
}
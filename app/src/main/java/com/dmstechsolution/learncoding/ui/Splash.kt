package com.dmstechsolution.learncoding.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dmstechsolution.learncoding.DashBordeActivity
import com.dmstechsolution.learncoding.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        val handler=Handler()
        handler.postDelayed({
            startActivity(Intent(this,DashBordeActivity::class.java))
        },2300)
    }
}
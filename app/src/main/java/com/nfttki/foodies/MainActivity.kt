package com.nfttki.foodies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()
        val r = object: Runnable{
            override fun run() {
                val i = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(r, 3*1000)
    }
}
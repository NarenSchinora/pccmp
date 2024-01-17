package com.myappf.pricecomparison

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class firstscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstscreen)

        val utp = findViewById<ImageView>(R.id.img)
        val kj = findViewById<Button>(R.id.button)
        val bkj = findViewById<ImageView>(R.id.imag)

        val ai = AnimationUtils.loadAnimation(this,R.anim.come)
        val oi = AnimationUtils.loadAnimation(this,R.anim.fade)
        val gh = AnimationUtils.loadAnimation(this,R.anim.up)


        utp.startAnimation(ai)
        bkj.startAnimation(oi)
        kj.startAnimation(gh)


        val bj = findViewById<Button>(R.id.button)
        bj.setOnClickListener {
            startActivity(Intent(this,intro::class.java))
            overridePendingTransition(R.anim.rei,R.anim.rey)
            finish()

        }


    }
}
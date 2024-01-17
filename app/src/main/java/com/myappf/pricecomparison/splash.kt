package com.myappf.pricecomparison

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.gms.ads.MobileAds


class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MobileAds.initialize(this)

        val mo = findViewById<MotionLayout>(R.id.make)
        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("firstStart", true)





        mo.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                if (firstStart) {
                    startActivity(Intent(this@splash, firstscreen::class.java))
                    finish()
                }else{
                    startActivity(Intent(this@splash, MainActivity::class.java))
                    overridePendingTransition(R.anim.rei,R.anim.rey)
                    finish()

                }




                val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putBoolean("firstStart", false)
                editor.apply()

            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

        })
    }
}
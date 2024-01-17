package com.myappf.pricecomparison

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class easter : AppCompatActivity() {
    private var kj:MediaPlayer? = null
    private var song = R.raw.rak

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easter)
        if (kj == null) {
            kj = MediaPlayer.create(this, song)
        }
        kj?.isLooping = true
        kj?.start()



    }


    override fun onBackPressed() {
        kj?.stop()
        finishActivity(101)
        super.onBackPressed()
    }


}
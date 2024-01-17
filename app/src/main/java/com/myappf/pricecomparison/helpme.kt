package com.myappf.pricecomparison

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class helpme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helpme)
        val tebv = findViewById<TextView>(R.id.textView7)
        tebv.text = "PLEASE WATCH THE FULL TUTORIAL BEFORE YOU USE THIS APP. \n\n IT IS RECOMMENDED TO WATCH THE TUTORIAL BEFORE USE.."+"\n\n"+"USE THIS LINK TO WATCH THE FULL TUTORIAL."+"\n\n" +"\n"+"https://youtu.be/R4oM_CnjnWg"


    }





}
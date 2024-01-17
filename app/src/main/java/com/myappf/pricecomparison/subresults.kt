package com.myappf.pricecomparison

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class subresults : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subresults)
        val adView = findViewById<AdView>(R.id.adView)

        val iny = intent
        var tad = intent.getStringExtra("nam").toString()
        val bad = intent.getStringExtra("lin").toString()
        val cad = intent.getStringExtra("pri").toString()

        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        var bard = emptyList<String>()
        var brad = emptyList<String>()
        var brd = emptyList<String>()

        fun gDumt(sizse: Int): List<items> {
            val lisct = ArrayList<items>()
            var texx = ""
            for (k in 0.until(sizse))
            {
                if (brd[k] == " 0 " || brd[k].equals(0)){
                    continue
                }

                texx = "Product Name: ${brad[k]} \n\n Product Price: ₹${brd[k]} \n\n Product Link: ${bard[k]}"
                val item = items(texx)
                lisct += item
            }

            return lisct
        }

        if (tad.isNotBlank()){
            val rec = findViewById<RecyclerView>(R.id.recyclerView)
             brad = tad.split("(||)").toMutableList()
             bard = bad.split("(||)").toMutableList()
             brd = cad.split("(||)").toMutableList()

            val exzx = gDumt(brad.size-1)
            rec.adapter = adapter(exzx)
            rec.layoutManager = LinearLayoutManager(this)
            rec.setHasFixedSize(true)


            }else{
                val backse = items("Empty list... \n\n Nothing here..")
            val exzx = ArrayList<items>()
            exzx += backse
            val rec = findViewById<RecyclerView>(R.id.recyclerView)
            rec.adapter = adapter(exzx)
            rec.layoutManager = LinearLayoutManager(this)
            rec.setHasFixedSize(true)



        }







    }

}
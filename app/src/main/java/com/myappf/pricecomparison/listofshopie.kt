package com.myappf.pricecomparison

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView

class listofshopie : AppCompatActivity() {
    private var bill = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofshopie)
        val amzi = findViewById<CardView>(R.id.amzi)
        val flipi = findViewById<CardView>(R.id.flipi)
        val snapi = findViewById<CardView>(R.id.snapi)
        val walla = findViewById<CardView>(R.id.wallj)
        val iadi = findViewById<CardView>(R.id.indiaaw)
        val paiti = findViewById<CardView>(R.id.payti)
        val ebai = findViewById<CardView>(R.id.ebaii)
        val aliba = findViewById<CardView>(R.id.alibas)
        val fati = AnimationUtils.loadAnimation(this,R.anim.fastfade)


        val ints = intent
        val tsdy = intent.getStringExtra("Ma")
        val bdy = intent.getStringExtra("ca")
        val sty = intent.getStringExtra("pr")
        val kzy = intent.getStringExtra("sh")

        val back = tsdy.toString().split("(|?-)").toMutableList()
        val sac = bdy.toString().split("(|?-)").toMutableList()
        val dac = sty.toString().split("(|?-)").toMutableList()
        val mac = kzy.toString().split(" ").toMutableList()


        amzi.startAnimation(fati)
        flipi.startAnimation(fati)
        snapi.startAnimation(fati)
        walla.startAnimation(fati)
        iadi.startAnimation(fati)
        paiti.startAnimation(fati)
        ebai.startAnimation(fati)
        aliba.startAnimation(fati)
        for(j in mac){
            if (j.isBlank()){
                mac.remove(j)
            }

        }

        back.removeAt(back.size-1)
        sac.removeAt(sac.size-1)
        dac.removeAt(dac.size-1)





       var u = 0

        var amaz=0
        var phip=0
        var snapp=0
        var alig=0
        var payu=0
        var ebaiu=0
        var walli=0
        var indiu=0
        println(mac)


       for(i in mac){
           if ("amazon" in i) {
              amaz = u

           }
           if ("flipkart" in i) {
               phip = u


           }
           if ("snapdeal" in i) {
               snapp = u


           }

           if ("walmart" in i) {
               walli= u

           }

           if ("alibaba" in i) {
                alig = u

           }

           if ("ebay" in i) {

               ebaiu = u

           }

           if ("paytm" in i) {
               payu = u


           }

           if ("indiamart" in i) {
               indiu = u


           }
           u+=1

       }





        amzi.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("amazon" in mac) {
                intse.putExtra("nam", back[amaz])
                intse.putExtra("lin", sac[amaz])
                intse.putExtra("pri", dac[amaz])
                startActivity(intse)
            }
            


        }

        flipi.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("flipkart" in mac) {
                intse.putExtra("nam", back[phip])
                intse.putExtra("lin", sac[phip])
                intse.putExtra("pri", dac[phip])
                startActivity(intse)
            }



        }

        snapi.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("snapdeal" in mac) {
                intse.putExtra("nam", back[snapp])
                intse.putExtra("lin", sac[snapp])
                intse.putExtra("pri", dac[snapp])
                startActivity(intse)

            }

        }

        walla.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("walmart" in mac) {
                intse.putExtra("nam", back[walli])
                intse.putExtra("lin", sac[walli])
                intse.putExtra("pri", dac[walli])
                startActivity(intse)

            }

        }

        iadi.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("indiamart" in mac) {
                intse.putExtra("nam", back[indiu])
                intse.putExtra("lin", sac[indiu])
                intse.putExtra("pri", dac[indiu])
                startActivity(intse)
            }


        }

        paiti.setOnClickListener {
            var intse = Intent(this, subresults::class.java)
            if ("paytm" in mac) {
                intse.putExtra("nam", back[payu])
                intse.putExtra("lin", sac[payu])
                intse.putExtra("pri", dac[payu])
                startActivity(intse)
            }



        }

        ebai.setOnClickListener {

            var intse = Intent(this, subresults::class.java)
            if ("ebay" in mac) {
                intse.putExtra("nam", back[ebaiu])
                intse.putExtra("lin", sac[ebaiu])
                intse.putExtra("pri", dac[ebaiu])
                startActivity(intse)
            }



        }

        aliba.setOnClickListener {
            if ("alibaba" in mac) {
                var intse = Intent(this, subresults::class.java)
                intse.putExtra("nam", back[alig])
                intse.putExtra("lin", sac[alig])
                intse.putExtra("pri", dac[alig])
                startActivity(intse)
            }

            

        }





    }







}
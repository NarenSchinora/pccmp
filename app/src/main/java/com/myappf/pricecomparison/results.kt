package com.myappf.pricecomparison

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isInvisible
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.google.android.gms.ads.rewarded.RewardedAd
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import kotlin.concurrent.thread
import kotlin.math.roundToInt


class results : AppCompatActivity(){
    private var bi = emptyList<String>().toMutableList()
    private var bu = ""
    private var amz = emptyList<List<String>>()
    private var bella = emptyList<String>()
    private var mz = emptyList<List<String>>()
    private var az = emptyList<List<Int>>()
    private var shopie = emptyList<String>()
    private var from = 0
    private var to = 0
    private var blk = 0
    private lateinit var intri:InterstitialAd



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        var james = ""
        val mub = findViewById<Button>(R.id.cmp)

       val inu = intent
        val ty = intent.getStringExtra("Mains").toString().toLowerCase()
       val by = intent.getStringExtra("category").toString().toLowerCase()
        val sy = intent.getStringExtra("shpos").toString().toLowerCase()
         val ky = intent.getStringExtra("price").toString()

        MobileAds.initialize(this)


        intri = InterstitialAd(this)
        intri.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        intri.loadAd(AdRequest.Builder().build())

        fun ondone(){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }



        intri.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {


            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                intri.loadAd(AdRequest.Builder().build())
                ondone()

            }
        }



        val jamvu = findViewById<Button>(R.id.pmp)
        jamvu.setOnClickListener {
            if (intri.isLoaded){
                intri.show()

            }else{
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }

        }
        val liki = emptyList<Int>().toMutableList()
        for (j in ky.split(" ")){
            if(j.isNotBlank()){
                liki += j.toInt()

            }
        }




        from = liki[0]
        to = liki[1]


        if (joner(ty) == joner(by)){
            james = ty
        }else{
            james = ty  +" "+ by
        }

        var my = emptyList<String>()
        for (i in sy.split(" ")){
            if (i.toLowerCase().isBlank()){
                continue
            }
            if(i.toLowerCase() !in my){
                my += i.toLowerCase()
            }
        }


        bella = my


        bi = ty.split(" ") as MutableList<String>
        bu = joner(ty.toString())
        for(os in my) {
            if ("amazon" in os) {
                amazon(james)

            }
            if ("flipkart" in os) {
                flipkart(james)

            }
            if ("snapdeal" in os) {
                snapdeal(james)

            }

            if ("walmart" in os) {
                walmart(james)

            }

            if ("alibaba" in os) {
                aliexpress(james)
            }

            if ("ebay" in os) {
                ebay(james)
            }

            if ("paytm" in os) {
                paytm(james)

            }

            if ("indiamart" in os) {
                Indiamart(james)

            }

        }

        mub.setOnClickListener {
            startActivity(Intent(this,favorite::class.java))

        }


    }











   private  fun runc(jc:String): List<Int> {
        var jb = jc.split(" ")
        var pc = emptyList<Int>()
        var ep = ""
        var bypa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        for (i in jb) {
            for (j in i.toString()) {
                if ( "," in j.toString() || "₹" in j.toString() || j.toString() in bypa || " " in j.toString()) {
                    continue
                }
                if("." in j.toString()){
                    break
                }

                if(j.toString() in "0123456789") {
                    ep += j.toString()
                }

            }
            if (ep.isNotBlank()) {
                pc += ep.toInt()
                ep = ""
            }

        }
        return pc


    }


    private fun makeit(sns: MutableList<MutableList<String>>,
                       uj: MutableList<MutableList<String>>,
                       svc: MutableList<MutableList<Int>>,
                       kdl: MutableList<String>){

      var baza = findViewById<Button>(R.id.comp)
        var kaka = ""
        var biku = ""
        var siku = ""
        for (n in 0.until(sns.size)){
            for (k in 0.until(sns[n].size)){
                biku += uj[n][k] + " "+ "(||)" +" "
                kaka += sns[n][k] +" " + "(||)" +" "
                siku += svc[n][k].toString() +" "+ "(||)" +" "
            }
            biku += "(|?-)" +" "
            kaka += "(|?-)" +" "
            siku += "(|?-)" +" "
        }


        var jambo = ""


        for(j in kdl){
            jambo += j +" "


        }




        baza.setOnClickListener {
            var inted = Intent(this, listofshopie::class.java)
            inted.putExtra("Ma", kaka)
            inted.putExtra("ca", biku)
            inted.putExtra("pr", siku)
            inted.putExtra("sh", jambo)
            startActivity(inted)
            overridePendingTransition(R.anim.ptas, R.anim.ketaas)
        }

    }




    private fun compryc(
        sn: MutableList<MutableList<String>>,
        suj: MutableList<MutableList<String>>,
        sc: MutableList<MutableList<Int>>,
        kl: MutableList<String>,
    ){



        val baj = sn
        val kj = suj
        val sxxcs = sc
        val baxchs = kl
        makeit(baj, kj, sxxcs, baxchs)

        val amzs = findViewById<ImageView>(R.id.amz)
        val fpls = findViewById<ImageView>(R.id.fpl)
        val wal = findViewById<ImageView>(R.id.wak)
        val ebas = findViewById<ImageView>(R.id.eba)
        val indi = findViewById<ImageView>(R.id.tget)
        val pay = findViewById<ImageView>(R.id.py)
        val alt = findViewById<ImageView>(R.id.al)
        val snar = findViewById<ImageView>(R.id.snap)


        var txt = findViewById<TextView>(R.id.finale)
        txt.text = "Load Successful"
        var litie = emptyList<Int>()
        var kutie =  emptyList<String>()
        var gutie =  emptyList<String>()
        var finale = ""
        var ball = emptyList<String>()


        for (k in 0.until(sc.size)){
            if (sn[k].isEmpty()){
                continue
            }
            else {

                for (v in 0.until(sc[k].size)) {

                    if (sc[k].isNotEmpty()) {
                        var indice = sc[k].indexOf(sc[k].min())
                        if (sc[k].min()!! >= from.toInt() && sc[k].min()!! <= to.toInt()) {
                            litie += sc[k][indice]
                            gutie += suj[k][indice]
                            kutie += sn[k][indice]
                            ball += kl[k]
                            break
                        }else{

                            sc[k].removeAt(indice)
                            sn[k].removeAt(indice)
                            suj[k].removeAt(indice)
                        }

                        if (sc[k].isEmpty()){
                            break
                        }


                    }


                }
            }
        }


        if (litie.isNotEmpty()) {
            var pidice = litie.indexOf(litie.min())
            var jas = kutie[pidice]
            var bass = litie[pidice]
            var losa = gutie[pidice]
            var lesa = ball[pidice]
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0.0f
            )


            val downn = AnimationUtils.loadAnimation(this, R.anim.down)
            if ("amazon" in lesa) {
                amzs.layoutParams = param
                if (amzs.isInvisible) {
                    amzs.startAnimation(downn)
                }
                amzs.visibility = View.VISIBLE


            }
            if ("flipkart" in lesa) {
                fpls.layoutParams = param
                if (fpls.isInvisible) {
                    fpls.startAnimation(downn)
                }
                fpls.visibility = View.VISIBLE


            }
            if ("snapdeal" in lesa) {
                snar.layoutParams = param
                if (snar.isInvisible) {
                    snar.startAnimation(downn)
                }
                snar.visibility = View.VISIBLE


            }

            if ("walmart" in lesa) {
                wal.layoutParams = param
                if (wal.isInvisible) {
                    wal.startAnimation(downn)
                }
                wal.visibility = View.VISIBLE


            }

            if ("alibaba" in lesa) {
                alt.layoutParams = param
                if (alt.isInvisible) {
                    alt.startAnimation(downn)
                }
                alt.visibility = View.VISIBLE


            }

            if ("ebay" in lesa) {
                ebas.layoutParams = param
                if (ebas.isInvisible) {
                    ebas.startAnimation(downn)
                }
                ebas.visibility = View.VISIBLE


            }

            if ("paytm" in lesa) {
                pay.layoutParams = param
                if (pay.isInvisible) {
                    pay.startAnimation(downn)
                }
                pay.visibility = View.VISIBLE


            }

            if ("indiamart" in lesa) {
                indi.layoutParams = param
                if (indi.isInvisible) {
                    indi.startAnimation(downn)
                }
                indi.visibility = View.VISIBLE


            }

            finale += "<font color=#5C00FF>${lesa.toUpperCase()}</font><font color=#F10B0B> has the best price..</font>" + "<br><br><font color=#DA00FF>Product Name:</font><br><br><font color=#000000>$jas</font>" + "<br><br><font color=#DA00FF>Price:</font><br><br><font color=#000000>₹$bass</font>" + "<br><br><font color=#DA00FF>Product Link:</font><br><br><font color=#00B0FF>$losa</font>"
            println(finale)
            txt.text = Html.fromHtml(finale)


        }
        else{
            txt.text = "Found nothing which matches your feeds..."
        }




    }







    private fun compare(
        comapy: String,
        ln: List<String>,
        lc: List<String>,
        lsc: List<String>,
        lssc: List<Int>,
    ): List<List<String>>? {
        for (mc in bi){
            if (mc.isBlank()){
                bi.remove(mc)

            }

        }


        blk += 1
        val names = emptyList<String>().toMutableList()
        val links = emptyList<String>().toMutableList()
        val pricee = emptyList<Int>().toMutableList()
        var finalname = emptyList<String>().toMutableList()
        var finallinks = emptyList<String>().toMutableList()
        val finalprice = emptyList<Int>().toMutableList()
        for (j in 0.until(lc.size)) {
            var jam = 0
            for (o in bi){
                if (o in lc[j]){
                    jam += 1
                }
            }

            if (jam == bi.size){
                names += ln[j]
                pricee += lssc[j]
                links += lsc[j]

            }


        }



        if (names.isEmpty()){


            for (u in 0.until(lc.size)){
                var lisci = emptyList<String>()
                var hm = ""
                var tysm = ""
                var chi =""
                for (i in bu){
                    hm += i
                    if (hm in lc[u]){
                            tysm = hm

                    }else{
                        lisci += tysm
                        hm = ""
                        hm += i

                    }


                }


                for (k in lisci){
                    chi += k
                }
                chi += tysm


                if (chi == bu){
                    names += ln[u]
                    pricee += lssc[u]
                    links += lsc[u]

                }else{

                }
            }
        }



        for(h in 0.until(names.size)){

            if (names.isEmpty()){
                break

            }




                var indice = pricee.indexOf(pricee.min())
                finalprice.plusAssign(pricee[indice])
                finallinks.plusAssign(links[indice])
                finalname.plusAssign(names[indice])
                names.remove(names[indice])
                links.remove(links[indice])
                pricee.remove(pricee[indice])





        }

        amz += listOf(finalname)
        mz += listOf(finallinks)
        az += listOf(finalprice)
        shopie += comapy



        if(blk == bella.size){

            compryc(amz as MutableList<MutableList<String>>,
                mz as MutableList<MutableList<String>>, az as MutableList<MutableList<Int>>,
                shopie as MutableList<String>)
        }

        return null

        
    }


    private fun dolla(gk: String, lk: List<Int>): MutableList<Int> {
        var fg = gk.split("")
        val citt = emptyList<Int>().toMutableList()
        for (kop in fg.indices){
            if("$" in fg[kop]){
                citt += lk[kop] * 73
            }else{
                citt += lk[kop]
            }

        }

        return citt


    }




    private  fun doci():Double {
        var kaprika = 0.toDouble()
            try {
                val kjunk = Jsoup.connect("https://google.com/search?q=" + "one dollar value in ruppee").get()
                val jum = kjunk.getElementsByClass("DFlfde SwHCTb")
                if (jum.isNotEmpty()){
                    kaprika = jum.text().toDouble()

                }


            }catch (e: IOException){


            }




        return kaprika

        }




    private fun dollc(li: List<Double>): MutableList<Int> {
        var kitch = doci()
        var dollar = 72.87.toDouble()
        if (kitch == 0.toDouble()){
        }
        else{
            dollar = kitch
        }

        val lkk = emptyList<Int>().toMutableList()
        for (r in li){
            lkk += (dollar*r).roundToInt()
        }
        return lkk


    }


    private fun joner(kpk: String): String {
        var jpk =""
        for (i in kpk.split(" ")){
            if (" " in i.toString()){
                continue
            }
            else {
                jpk += i
            }
        }
        return jpk.toLowerCase()
    }


    private fun remo(cb: String): List<Int> {
        var jb = cb.split(" ")
        var pb = emptyList<Int>()
        var ep = ""
        var bypa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        for (i in jb) {
            for (j in i.toString()) {
                if ("." in j.toString() || "," in j.toString() || "₹" in j.toString() || j.toString() in bypa || " " in j.toString()) {
                    continue
                }

                if(j.toString() in "0123456789") {
                    ep += j.toString()
                }

            }
            if (ep.isNotBlank()) {
                pb += ep.toInt()
                ep = ""
            }

        }
        return pb


    }






    private fun los(jn: String): MutableList<Int> {
        var biji = jn.split("$").toMutableList()
        val list = emptyList<Double>().toMutableList()
        for (p in biji.indices){
            if(biji[p].isEmpty()){
                continue
            }
            else if("," in biji[p]){
                var kpl = ""
                for (k in biji[p]){
                    if ("," in k.toString()){
                        continue
                    }
                    else{
                        kpl += k
                    }
                }
                list += kpl.toDouble()

            }

            else{

                list += biji[p].toDouble()
            }
        }

        var joba =  dollc(list)
        return joba
    }




    private fun amazon(jmk: String){
        thread {
            try {

                var spo = ""
                var go = ""
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                val wb = Jsoup.connect("https://www.amazon.in/s?k=" + jmk.toLowerCase()).referrer("http://www.google.com").timeout(5000).get()
                var jkg = wb.getElementsByClass("a-section a-spacing-medium")
                if (jkg.isEmpty()){
                    jkg = wb.getElementsByClass("a-section a-spacing-medium a-text-center")

                }


                for (p in jkg)
                {
                    var cb = p.getElementsByClass("a-price-whole")
                    var jkms = p.getElementsByClass("s-line-clamp-1")






                        if (cb.isNotEmpty()) {
                            var p1 = p.getElementsByClass("a-link-normal a-text-normal")
                            var kob = cb.text().split(" ")[0]
                            spo += "$kob "
                            var ck = p.getElementsByClass("a-link-normal a-text-normal").attr("abs:href")
                            kpmain += ck
                            if (jkms.isEmpty()) {
                                kibi += p1.text()
                                libi += joner(p1.text().toString())
                            }else{
                                kibi += jkms.text() + " " + p1.text()
                                libi += joner(jkms.text() + " " +p1.text().toString())

                            }
                        }

                }

                var litt = remo(spo).toMutableList()


                if (litt.size == libi.size) {


                }else{
                    for (u in 0.until(libi.size)){
                        litt.removeAt(u)
                    }

                }


                this.runOnUiThread {

                    compare("amazon", kibi, libi, kpmain, litt)

                }

            } catch (e: IOException) {



            }

        }

    }




    private fun flipkart(img: String){
        thread {
            try {


                val wb = Jsoup.connect("https://www.flipkart.com/search?q=" + img.toLowerCase()).timeout(5000).referrer(
                    "http://www.google.com").get()
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                val kjk = wb.getElementsByClass("_30jeq3 _1_WHN1")
                val bvb = wb.getElementsByClass("_30jeq3")
                val sec = Elements()
                var litt = emptyList<Int>()
                for (u in 0.until(1)) {
                    if (kjk.isNotEmpty()) {
                        var liji = wb.getElementsByClass("_4rR01T")
                        for (opo in liji){
                            kibi += opo.text()
                            libi += joner(opo.text())
                        }
                        var biji = wb.getElementsByClass("_1fQZEK")
                        for (lol in biji){
                            var kol = lol.absUrl("href")
                            kpmain += kol
                        }
                        litt = remo(kjk.text())
                        break

                    }
                    if (bvb.isNotEmpty()) {
                        var jag = wb.getElementsByClass("s1Q9rs")
                        if (jag.isNotEmpty()){
                            for (opo in jag){
                                kibi += opo.text()
                                libi += joner(opo.text())
                            }
                            for (lol in jag){
                                var kol = lol.absUrl("href")
                                kpmain += kol

                            }

                        }

                        var flaj = wb.getElementsByClass("_2B099V")
                        if (flaj.isNotEmpty()){
                            var i=1

                            for(x in flaj){
                                var tyson = x.text().split("₹")
                                kibi += tyson[0]
                                libi += joner(tyson[0])


                            }

                            var bk = flaj.select("a")

                            for (opoi in bk){
                                var bson =  opoi.absUrl("href")
                                println(bson)
                                if (bson in kpmain){
                                    continue
                                }else{
                                    kpmain+=bson

                                }

                            }

                        }



                        for (i in bvb) {
                            if (i.className().equals("_30jeq3 UMT9wN")) {
                                    continue
                            }
                            else {
                                sec.add(i)
                            }


                        }

                        litt = remo(sec.text())



                    }
                }


                this.runOnUiThread {
                    compare("flipkart", kibi, libi, kpmain, litt)


                }
            } catch (e: IOException) {


            }

        }


    }


    private fun walmart(jkm: String) {
        thread {
            try {

                val wb = Jsoup.connect("https://www.walmart.com/search/?query=" + jkm.toLowerCase()).timeout(5000).referrer(
                    "http://www.google.com")
                    .get()
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()

                val kmn = wb.getElementsByClass("product-price-with-fulfillment")
                val bmn  = wb.getElementsByClass("product-title-link line-clamp line-clamp-2 truncate-title")
                var g = 0
                var khl = ""
                var tb =""


                for(kopj in kmn){
                    val jacfm = kopj.getElementsByClass("price-main-block")

                    if (jacfm.isEmpty()){
                        tb += "$000" + " "

                    }else {
                        for(u in jacfm) {
                            val majo = u.select("span.visuallyhidden")
                            val kaja = majo.text().split(" ")[0]
                            if (kaja.isBlank()) {
                                tb += "$000" + " "

                            } else {
                                tb += kaja.toString() + " "
                            }


                            if (g == 39) {
                                break
                            }
                            g += 1
                        }
                    }
                }





                g = 0
                for (i in bmn){
                    var jh = i.text()
                    kibi += jh.toString()
                    libi += joner(jh.toString())
                    var gkl = i.absUrl("href")
                    kpmain += gkl
                    if(g==39){
                        break
                    }
                    g+=1


                }
                

                var litt = los(tb)





                this.runOnUiThread {
                    println(wb.getElementsByClass("price-main-block").text())
                    println(kibi)
                    println(kibi.size)
                    println(litt)
                    println(litt.size)


                    compare("walmart", kibi, libi, kpmain, litt)

                }
            } catch (e: IOException) {


            }


        }

    }





    private fun Indiamart(bait: String){
       
        thread {
            try {

                val wb:Document = Jsoup.connect("https://dir.indiamart.com/search.mp?ss=" + bait.toLowerCase()).timeout(5000).referrer(
                    "http://www.google.com")
                    .get()

                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                val kmn = wb.getElementsByClass("ht100")
                var chi = ""
                var jab = 0
                    for (u in kmn) {
                        if (jab%2 == 0) {
                            val jb = u.getElementsByClass("prc cp")
                            val jc = u.getElementsByTag("a")
                            if ("lakh" in jb.text().toLowerCase()){
                                continue
                            }
                            if (jb.text().isNotBlank() && "/" in jb.text()) {
                                for (n in jc) {
                                    kibi += n.text()
                                    libi += joner(n.text())
                                    kpmain += n.absUrl("href")
                                    break
                                }
                                chi += jb.text().split("/")[0] + " "
                            }
                        }
                        jab += 1

                    }



                var litt = remo(chi)

                this.runOnUiThread {
                    compare("indiamart", kibi, libi, kpmain, litt)

                }
            } catch (e: IOException) {


            }


        }


    }

    private fun snapdeal(pait: String){

        thread {
            try {

                val wb = Jsoup.connect("https://www.snapdeal.com/search?keyword=" + pait.toLowerCase()).timeout(5000)
                    .referrer(
                        "http://www.google.com").get()
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                var chi = ""
                val kmn = wb.getElementsByClass("product-desc-rating")
                var blk =""
                var h=0

                for(u in kmn){
                    val jb = u.getElementsByTag("a")
                    val kob = u.getElementsByClass("lfloat product-price")
                    if("Rs." in kob.text()){
                        var kal = ""
                        for(l in kob.text().split(".")[1]){
                            if("," in l.toString()){
                                continue
                            }else if(l in "0123456789"){
                                kal += l.toString()
                            }

                        }
                        blk = kal

                    }else{
                        blk = kob.text()
                    }
                    chi += blk + " "
                    kpmain += jb.attr("href")
                    kibi += jb.text()
                    libi += joner(jb.text())


                    if(h == 39){
                        break
                    }
                    h+=1
                }
                var litt = remo(chi)



                this.runOnUiThread {
                    compare("snapdeal", kibi, libi, kpmain, litt)

                }
            } catch (e: IOException) {



            }


        }



    }




    private fun aliexpress(dates: String){

        thread {
            try {

                val wb:Document = Jsoup.connect("https://www.alibaba.com/trade/search?fsb=y&IndexArea=product_en&CatId=&SearchText=" + dates.toLowerCase()).timeout(5000)
                    .referrer(
                        "http://www.google.com").get()



                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                var chi = ""
                val kmn = wb.getElementsByClass("elements-title-normal__outter")
                var bagu = emptyList<String>()


                for(u in kmn){
                    val jb = u.getElementsByTag("a")
                    for (n in jb){
                        kpmain += n.absUrl("href")
                    }
                    kibi += jb.text()
                    libi += joner(jb.text())


                }



                val bms = wb.getElementsByClass("elements-offer-price-normal__price")
                for (u in bms){
                    if("-" in u.text()){
                        bagu += u.text().split("-")[0]
                    }else{
                        bagu += u.text()
                    }
                }





                for (fg in bagu){
                    chi += fg + " "

                }
                println(chi)
                var litt = emptyList<Int>()

                if ("$" in chi){
                    litt = los(chi)
                }
                if ("₹" in chi){
                    litt = runc(chi)
                }


                if (kibi.size == litt.size){

                }else{
                    kibi = emptyList()
                    kpmain = emptyList()
                    litt = emptyList()
                    libi = emptyList()
                    bagu = emptyList()
                    chi = ""

                    var elementsties =
                        wb.getElementsByClass("organic-gallery-offer-outter J-offer-wrapper")
                    for (u in elementsties) {
                        val kmn = u.getElementsByClass("elements-title-normal__outter")
                        val bms = u.getElementsByClass("elements-offer-price-normal__price")
                        if (bms.isNotEmpty()) {
                            for (j in kmn) {
                                val jb = j.getElementsByTag("a")
                                for (n in jb) {
                                    kpmain += n.absUrl("href")
                                }
                                kibi += jb.text()
                                libi += joner(jb.text())
                            }
                            for (u in bms) {
                                if ("-" in u.text()) {
                                    bagu += u.text().split("-")[0]
                                } else {
                                    bagu += u.text()
                                }
                            }
                        }


                    }


                    for (fg in bagu){
                        chi += fg + " "

                    }

                    if ("$" in chi){
                        litt = los(chi)
                    }
                    if ("₹" in chi){
                        litt = runc(chi)
                    }


                }








                this.runOnUiThread {
                    compare("alibaba", kibi, libi, kpmain, litt)

                }
            } catch (e: IOException) {


            }


        }

    }




    private fun paytm(pates: String){

        thread {
            try {
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                val wb = Jsoup.connect("https://paytm.com/shop/search?q=" + pates.toLowerCase()).timeout(5000).referrer(
                    "http://www.google.com").get()
                val jkg = wb.getElementsByClass("_2i1r")
                var spo = ""
                var h = 0
                for (p in jkg)
                {
                    val kam = p.getElementsByClass("_1kMS")
                    spo += kam.text()
                    val mam = p.getElementsByTag("a")
                    for (k in mam){
                        kpmain += k.absUrl("href")
                        break
                    }
                    val jam = p.getElementsByClass("_2apC")
                    kibi += jam.text()
                    libi += joner(jam.text())

                    if (h==39){
                        break
                    }


                }
                var litt = remo(spo)

                this.runOnUiThread {

                    compare("paytm", kibi, libi, kpmain, litt)


                }
            } catch (e: IOException) {



            }

        }


    }






    private fun ebay(hgk: String){

        thread {
            try {

                val wb = Jsoup.connect("https://www.ebay.com/sch/i.html?_nkw=" + hgk.toLowerCase()).timeout(5000)
                    .referrer(
                        "http://www.google.com").get()
                var kibi = emptyList<String>()
                var kpmain = emptyList<String>()
                var libi = emptyList<String>()
                var chi = ""
                val kmn = wb.getElementsByClass("s-item__wrapper clearfix")
                var blk =""


                var h=0
                for(u in kmn){

                    val jb = u.getElementsByTag("a")
                    val kob = u.getElementsByClass("s-item__price")
                    if (kob.text().split(" ").size == 2){
                       blk = kob.text().split(" ")[0].toString()
                    }
                    else if("to" in kob.text()){
                        blk = kob.text().split("to")[0]
                    }else{
                        blk = kob.text()
                    }
                    chi += blk + " "
                    kpmain += jb.attr("href")
                    kibi += jb.text()
                    libi += joner(jb.text())


                    if(h == 39){
                        break
                    }
                        h+=1
                }
                var litt = los(chi)



                this.runOnUiThread {
                    compare("ebay", kibi, libi, kpmain, litt)


                }
            } catch (e: IOException) {


            }


        }



    }


    override fun onBackPressed() {
        val kbi = android.app.AlertDialog.Builder(this)
        kbi.setTitle("Close app")
        kbi.setMessage("Do you really want to close the app?")
        kbi.setPositiveButton("YES",
            { dialogInterface: DialogInterface, i: Int ->
                finishAffinity()

            })
        kbi.setNegativeButton("Cancel",{ dialogInterface: DialogInterface, i: Int ->
        })
        kbi.show()
    }




}


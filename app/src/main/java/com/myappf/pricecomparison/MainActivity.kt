package com.myappf.pricecomparison

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.airbnb.lottie.LottieAnimationView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var stt = 0
    private var op = 1
    var litt = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
    val blb = booleanArrayOf(false, false, false, false, false, false, false, false)
    private var jl = emptyList<String>()
    private  var opp = 0
    private var mainstr:String = ""
    private lateinit var intadd:InterstitialAd



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MobileAds.initialize(this)
        intadd = InterstitialAd(this)
        intadd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        intadd.loadAd(AdRequest.Builder().build())

        val pres = getSharedPreferences("pres", MODE_PRIVATE)
        val firsttart = pres.getBoolean("firsttart", true)


        fun alertd(){
            if(firsttart) {

                val fbi = android.app.AlertDialog.Builder(this)
                fbi.setTitle("Watch Tutorial")
                fbi.setMessage("Please watch the tutorial video before use." + "\n" +"Skip this at your own risk.")
                fbi.setPositiveButton("Watch Video",
                    { dialogInterface: DialogInterface, i: Int ->
                        val urst = Uri.parse("https://youtu.be/R4oM_CnjnWg")
                        val ut = Intent(Intent.ACTION_VIEW,urst)
                        try {
                            startActivity(ut)
                        }catch (e:Exception){
                            Toast.makeText(this,"There was an error."+"Please click the help button in the navigation bar..",Toast.LENGTH_LONG).show()
                        }

                    })
                fbi.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int ->
                })
                fbi.show()

                val pres = getSharedPreferences("pres", MODE_PRIVATE)
                val editor = pres.edit()
                editor.putBoolean("firsttart", false)
                editor.apply()
            }
        }
        alertd()



        var gc = emptyArray<String>()
        var lit = arrayOf("Amazon",
            "Flipkart",
            "Snapdeal",
            "Walmart",
            "Alibaba",
            "Ebay",
            "Paytm",
            "Indiamart")
        var blv = booleanArrayOf(false, false, false, false, false, false, false, false)
        var kplist = emptyList<String>()
        val dra = findViewById<DrawerLayout>(R.id.drawer)
        val toll = findViewById<Toolbar>(R.id.dd)
        val sc = findViewById<SearchView>(R.id.ghu)
        var bpress:Boolean = false
        var pj:String? = ""
        val in1 = AnimationUtils.loadAnimation(this, R.anim.in1)
        val out1 = AnimationUtils.loadAnimation(this, R.anim.out1)
        val nav = findViewById<NavigationView>(R.id.nav)
        val lotte = findViewById<LottieAnimationView>(R.id.lott)
        var tpro = mutableListOf<String>("")
        val itp = AnimationUtils.loadAnimation(this, R.anim.`in`)
        val kite = AnimationUtils.loadAnimation(this, R.anim.out)
        val am = findViewById<ImageView>(R.id.amazon)
        val fp = findViewById<ImageView>(R.id.flipkart)
        val fad = AnimationUtils.loadAnimation(this, R.anim.fade)
        val lots = findViewById<LottieAnimationView>(R.id.lots)
        val tpt = findViewById<TextView>(R.id.textView)
        var bpb = booleanArrayOf()
        var ik = false
        val oiu = AnimationUtils.loadAnimation(this, R.anim.fadeout)
        val jcb = AnimationUtils.loadAnimation(this, R.anim.up)
        setSupportActionBar(toll)
        nav.bringToFront()
        val bkb = findViewById<Button>(R.id.bu)
        val snap = findViewById<ImageView>(R.id.snapdeal)
        val walm = findViewById<ImageView>(R.id.walmart)
        val eb = findViewById<ImageView>(R.id.ebay)
        val ali = findViewById<ImageView>(R.id.aliexpress)
        val tar = findViewById<ImageView>(R.id.target)
        val pay = findViewById<ImageView>(R.id.paytm)
        val sw = findViewById<Switch>(R.id.sw)
        val tt = findViewById<TextView>(R.id.from)
        val editt = findViewById<EditText>(R.id.editt)
        var emps = "0"
        var gums ="0"
        val getou = AnimationUtils.loadAnimation(this, R.anim.fastfaeout)
        val fastfade = AnimationUtils.loadAnimation(this, R.anim.fastfade)
        val cate = findViewById<TextView>(R.id.cat)
        val pate = findViewById<EditText>(R.id.edi)
        var kams = ""
        var ct = findViewById<TextView>(R.id.to)
        var ed = findViewById<EditText>(R.id.ed)

        val togg = ActionBarDrawerToggle(this, dra, toll, R.string.nav_open, R.string.nav_close)
         dra.addDrawerListener(togg)
        togg.syncState()
        nav.setNavigationItemSelectedListener(this)



        fun onpress(){
            if(bpress){
                sc.clearFocus()
                bpress = false
            }


        }



        intadd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
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
                intadd.loadAd(AdRequest.Builder().build())

            }
        }


        if(op==1) {
            lots.startAnimation(fad)
            lotte.startAnimation(fad)
            tpt.startAnimation(fad)
            lotte.playAnimation()
            lots.playAnimation()
            op+=1
        }

        fun cont(){

            if (mainstr.toLowerCase() == "compryc"){
                startActivity(Intent(this,helpme::class.java))
            }

            if (mainstr.isNotBlank() && jl.size >= 2 && bkb.isInvisible && cate.isInvisible && pate.isInvisible){


                cate.visibility = View.VISIBLE
                pate.visibility = View.VISIBLE
                cate.startAnimation(fastfade)
                pate.startAnimation(fad)


            }
            if (jl.size<2 || mainstr.isBlank()){
                if (pate.isVisible && cate.isVisible){

                    cate.startAnimation(getou)
                pate.startAnimation(oiu)
                    cate.visibility = View.INVISIBLE
                pate.visibility = View.INVISIBLE

                }
            }

            if(jl.size<2 && bkb.isVisible){
                bkb.startAnimation(oiu)
                bkb.visibility = View.INVISIBLE
            }
            if (mainstr.isBlank() && bkb.isVisible){
                bkb.startAnimation(oiu)
                bkb.visibility = View.INVISIBLE


            }


            if (pate.isVisible) {

                if (kams.isBlank() && bkb.isVisible) {
                    bkb.startAnimation(oiu)
                    bkb.visibility = View.INVISIBLE

                }
            }


            if (jl.size >= 2 && mainstr.isNotBlank() && bkb.isInvisible && kams.isNotBlank()){
                bkb.visibility = View.VISIBLE
                bkb.startAnimation(jcb)
            }


            if (bkb.isInvisible){
                if (sw.isVisible){
                    sw.startAnimation(oiu)
                }
                sw.visibility = View.INVISIBLE

            }
            if(bkb.isVisible){
                if(sw.isInvisible){
                    sw.startAnimation(fad)
                }
                sw.visibility = View.VISIBLE



            }



        }

        pate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int,
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int,
            ) {
                kams = pate.text.toString()


            }

            override fun afterTextChanged(s: Editable?) {


            }

        })


        pate.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(
                v: TextView?,
                actionId: Int,
                event: KeyEvent?,
            ): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND) {
                    closeKeyboard()
                    cont()
                }
                return false

            }


        })









            sw.setOnCheckedChangeListener{ compoundbutton, onSwitch ->
                if(onSwitch){

                    if (tt.isInvisible &&  editt.isInvisible && ct.isInvisible && ed.isInvisible ){
                        tt.startAnimation(fastfade)
                        editt.startAnimation(fastfade)
                        ct.startAnimation(fastfade)
                        ed.startAnimation(fastfade)
                    }
                    tt.visibility = View.VISIBLE
                    editt.visibility = View.VISIBLE
                    ct.visibility = View.VISIBLE
                    ed.visibility = View.VISIBLE

                    if (sw.isInvisible){
                        if (tt.isVisible  && editt.isVisible && ct.isVisible && ed.isVisible){
                            tt.startAnimation(getou)
                            editt.startAnimation(getou)
                            ct.startAnimation(getou)
                            ed.startAnimation(getou)
                        }
                        tt.visibility = View.INVISIBLE
                        editt.visibility = View.INVISIBLE
                        ct.visibility = View.INVISIBLE
                        ed.visibility = View.INVISIBLE
                    }


                }
                else{

                    if (tt.isVisible  && editt.isVisible && ct.isInvisible && ed.isInvisible ){
                        tt.startAnimation(getou)
                        editt.startAnimation(getou)
                        ct.startAnimation(getou)
                        ed.startAnimation(getou)
                    }

                    tt.visibility = View.INVISIBLE
                    editt.visibility = View.INVISIBLE
                    ct.visibility = View.INVISIBLE
                    ed.visibility = View.INVISIBLE

                }

            }



            editt.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {

                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int,
                ) {
                    emps = editt.text.toString()


                }

                override fun afterTextChanged(s: Editable?) {


                }

            })



        editt.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(
                v: TextView?,
                actionId: Int,
                event: KeyEvent?,
            ): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND) {
                    closeKeyboard()
                }
                return false

            }


        })


        ed.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int,
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int,
            ) {
                gums = ed.text.toString()


            }

            override fun afterTextChanged(s: Editable?) {


            }

        })



        ed.setOnEditorActionListener(object : OnEditorActionListener {
            override fun onEditorAction(
                v: TextView?,
                actionId: Int,
                event: KeyEvent?,
            ): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_SEND) {
                    closeKeyboard()
                }
                return false

            }


        })





         lotte.setOnClickListener {
             bpress = true
             onpress()


             val build = AlertDialog.Builder(this)
             build.setTitle("Choices")
             build.setMultiChoiceItems(lit, blv) { dialog, which, isChecked ->
                     blv[which] = isChecked

             }

             build.setPositiveButton("Confirm") { dialog, which ->

                 for (i in blv.indices) {
                     val checked = blv[i]
                     if (checked) {
                         if (litt[i].toString() in tpro || litt[i].toString() in jl){
                             continue
                         }
                        else {
                            ik = true
                            tpro.add(lit[i])
                             jl += lit[i]


                         }



                     }

                 }


                 for (k in blv.indices) {
                     blv.set(k, false)
                 }

                 kplist = jl

                 lotte.playAnimation()

                 for (kl in jl){

                     if ("Amazon" in jl && am.isInvisible){
                         am.visibility = View.VISIBLE
                         am.startAnimation(itp)
                     }
                     if ("Flipkart" in jl && fp.isInvisible){
                         fp.visibility = View.VISIBLE
                         fp.startAnimation(kite)
                     }
                     if ("Snapdeal" in jl && snap.isInvisible){
                         snap.visibility = View.VISIBLE
                         snap.startAnimation(itp)
                     }
                     if ("Walmart" in jl && walm.isInvisible){
                         walm.visibility = View.VISIBLE
                         walm.startAnimation(kite)
                     }
                     if ("Alibaba" in jl && ali.isInvisible){
                         ali.visibility = View.VISIBLE
                         ali.startAnimation(itp)
                     }
                     if ("Ebay" in jl && eb.isInvisible){
                         eb.visibility = View.VISIBLE
                         eb.startAnimation(kite)
                     }
                     if ("Paytm" in jl && pay.isInvisible){
                         pay.visibility = View.VISIBLE
                         pay.startAnimation(itp)
                     }
                     if ("Indiamart" in jl && tar.isInvisible){
                         tar.visibility = View.VISIBLE
                         tar.startAnimation(kite)
                     }



                 }
                 cont()

             }










             build.setNeutralButton("Go back") { dialog, which ->
                 for (k in blv.indices) {
                     blv.set(k, false)
                 }
                 lotte.playAnimation()
                 cont()
             }
             val dialog = build.create()
             dialog.show()

             lotte.playAnimation()
         }









        lots.setOnClickListener {
            bpress = true
            onpress()
            if (kplist.isEmpty()){
                Toast.makeText(this, "Please select the choices first", Toast.LENGTH_LONG).show()
            }

            else {

                if (ik == true) {

                    for (i in kplist) {

                        if (i.isNotBlank()) {
                            if (i in gc || i.length == 0) {
                                continue
                            } else {

                                gc += i
                            }

                        }
                    }


                    for (elem in gc) {
                        if (bpb.size != gc.size) {
                            bpb += false
                        }
                    }
                    ik=false
                }


                val tpo = mutableListOf<String>("")
                if (gc.isEmpty()) {
                    Toast.makeText(this, "Please select the choices first", Toast.LENGTH_LONG).show()
                } else {


                    val builde = AlertDialog.Builder(this)
                    builde.setTitle("Remove Choices")

                    builde.setMultiChoiceItems(gc, bpb) { dialog, which, isChecked ->
                        bpb[which] = isChecked

                    }

                    builde.setPositiveButton("Confirm") { dialog, which ->
                        if (bpb.isNotEmpty()) {

                            for (i in bpb.indices) {
                                val checked = bpb[i]
                                if (checked) {
                                    if (gc[i].toString() in tpo) {
                                        continue
                                    } else {
                                        tpo.add(gc[i])

                                    }

                                }
                            }

                            var result =  gc.toMutableList()
                            for (op in tpo){
                                if (op in result){
                                    result.remove(op)

                                }
                            }
                            println(result)


                            jl = result.toList()
                            gc = result.toTypedArray()


                            var resul =  bpb.toMutableList()
                            for (op in bpb){
                                if (op  == true){
                                    resul.remove(op)

                                }
                            }
                            bpb = resul.toBooleanArray()

                            for (k in bpb.indices) {
                                bpb.set(k, false)
                            }
                        } else {
                            Toast.makeText(this, "No choices to be removed", Toast.LENGTH_LONG).show()
                        }

                        lots.playAnimation()
                        for (kl in tpo){
                            if ("Amazon" in tpo){
                                am.startAnimation(in1)
                                am.visibility = View.INVISIBLE
                            }
                            if ("Flipkart" in tpo){
                                fp.startAnimation(out1)
                                fp.visibility = View.INVISIBLE
                            }

                            if ("Snapdeal" in tpo){
                                snap.startAnimation(in1)
                                snap.visibility = View.INVISIBLE
                            }

                            if ("Walmart" in tpo){
                                walm.startAnimation(out1)
                                walm.visibility = View.INVISIBLE
                            }

                            if ("Alibaba" in tpo){
                                ali.startAnimation(in1)
                                ali.visibility = View.INVISIBLE
                            }

                            if ("Ebay" in tpo){
                                eb.startAnimation(out1)
                                eb.visibility = View.INVISIBLE
                            }

                            if ("Paytm" in tpo){
                                pay.startAnimation(in1)
                                pay.visibility = View.INVISIBLE
                            }

                            if ("Indiamart" in tpo){
                                tar.startAnimation(out1)
                                tar.visibility = View.INVISIBLE
                            }
                        }

                        cont()

                    }




                    builde.setNeutralButton("Go back") { dialog, which ->
                        for (k in bpb.indices) {
                            bpb.set(k, false)
                        }
                        lots.playAnimation()
                        cont()
                    }
                    val dialoge = builde.create()
                    dialoge.show()


                }

                lots.playAnimation()
            }
        }






        bkb.setOnClickListener {
            try {



                var bile = true


                if (mainstr.isBlank()){
                    bile = false
                }
                if(jl.size<2){
                    bile = false
                }
                if(kams.isBlank()){
                    bile = false
                }


                if (emps.toDouble() >=0  && gums.toDouble() > 0 &&  emps.toDouble() != gums.toDouble()) {
                    if (gums.toDouble() > emps.toDouble()){
                        bile = true
                    }else{
                        Toast.makeText(this,"Make sure that 'to' is greater than 'from'",Toast.LENGTH_LONG).show()
                        bile = false
                    }


                }
                if(emps.toDouble() == gums.toDouble()){
                    bile =false
                    Toast.makeText(this,"Make sure that they are not equal",Toast.LENGTH_LONG).show()

                }
                if (emps.toDouble() == 0.toDouble() && gums.toDouble() == 0.toDouble()){
                    Toast.makeText(this,"Please make sure that the 'to' price is not equal to 0",Toast.LENGTH_LONG).show()
                }



                if (bile) {
                    if (intadd.isLoaded){
                        intadd.show()

                    }else{
                        println("no add")
                    }


                    var ftp = "$mainstr"
                    var ptp = ""
                    var st = ""
                    var kt = ""
                    if (emps.isNotBlank()){
                        ptp = "$emps $gums"
                    }
                    println(ptp)

                    for (l in jl){
                        st += l +" "
                    }

                    kt = kams







                    val bi = android.app.AlertDialog.Builder(this)
                    bi.setTitle("Start comparing")
                    bi.setMessage("Are you sure with your decisions?")
                    bi.setPositiveButton("YES",
                        { dialogInterface: DialogInterface, i: Int ->
                            var inte = Intent(this, results::class.java)
                            inte.putExtra("Mains", ftp)
                            inte.putExtra("category", kams)
                            inte.putExtra("shpos", st)
                            inte.putExtra("price", ptp)


                            startActivity(inte)
                            overridePendingTransition(R.anim.rep, R.anim.ren)
                        })
                    bi.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int -> })
                    bi.show()

                }


            }catch (e: Exception){
                Toast.makeText(this,"Please make sure that the prices are not empty ",Toast.LENGTH_LONG).show()
            }


        }




        sc.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                pj = query.toString()
                mainstr = act(pj!!)
                sc.clearFocus()
                cont()
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                bpress = true
                return true

            }


        })





    }








    private  fun act(jk: String): String{
        val sc = findViewById<SearchView>(R.id.ghu)
        sc.clearFocus()
        return jk.toString()
    }


    override fun onBackPressed() {
        val dra = findViewById<DrawerLayout>(R.id.drawer)
        val sc = findViewById<SearchView>(R.id.ghu)
        sc.clearFocus()

        if (dra.isDrawerOpen(GravityCompat.START)){
            dra.closeDrawer(GravityCompat.START)

        }
        else {
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        val sc = findViewById<SearchView>(R.id.ghu)
        sc.clearFocus()

        val dra = findViewById<DrawerLayout>(R.id.drawer)



        if (item.itemId == R.id.ome){
            if (dra.isDrawerOpen(GravityCompat.START)){
                dra.closeDrawer(GravityCompat.START)

            }
            stt+=1

        }

        if (stt == 5){
            stt = 66
            startActivity(Intent(this, easter::class.java))

        }



        if (item.itemId != R.id.ome){
            if (item.itemId == R.id.share){
                val intu = Intent(Intent.ACTION_SEND)
                intu.setType("text/plain")
                val sub = "COMPRYC - a price comparison app to make purchases easier"
                val bod = "Clink on the link below to download the app" +"\n\n" + "https://play.google.com/store/apps/details?id="+ applicationContext.packageName
                intu.putExtra(Intent.EXTRA_SUBJECT,sub)
                intu.putExtra(Intent.EXTRA_TEXT,bod)
                try {
                    startActivity(Intent.createChooser(intu,"Share"))
                }catch (e:Exception){
                    Toast.makeText(this,"Try again later..",Toast.LENGTH_LONG).show()
                }


            }

            if (item.itemId == R.id.rate){
                val urt = Uri.parse("https://play.google.com/store/apps/details?id="+ applicationContext.packageName)
                val uti = Intent(Intent.ACTION_VIEW,urt)
                try {
                    startActivity(uti)
                }catch (e:Exception){
                    Toast.makeText(this,"Sorry..Try again later..",Toast.LENGTH_LONG).show()
                }


            }

            if (item.itemId == R.id.mail){
                Toast.makeText(this,"Email: \n compryc@gmail.com",Toast.LENGTH_LONG).show()
            }

            if (item.itemId == R.id.help){
                startActivity(Intent(this,helpme::class.java))
            }


            if (dra.isDrawerOpen(GravityCompat.START)) {
                dra.closeDrawer(GravityCompat.START)

            }
        }
        return true
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }




}
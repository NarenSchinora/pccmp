package com.myappf.pricecomparison

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class intro : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(AppIntroFragment.newInstance(
            title = "FAST COMPARISON",
            description = "MAKE COMPARISIONS EASIER AND GET YOUR RESULTS WITHIN A SHORT PERIOD OF TIME",
            imageDrawable = R.drawable.itsacircl,
            backgroundDrawable = R.drawable.coius,
            titleColor = Color.parseColor("#FD3D00"),
            descriptionColor = Color.parseColor("#FD3D00"),
            titleTypefaceFontRes = R.font.sh,
            descriptionTypefaceFontRes = R.font.sh,
        ))

        addSlide(AppIntroFragment.newInstance(
            title = "COUNTLESS SEARCHES",
            description = "SEARCH AND GET WIDE RANGE OF PRODUCTS WHICH IS PERFECT FOR YOUR BUDGET",
            imageDrawable = R.drawable.minego,
            backgroundDrawable = R.drawable.sacw,
            titleColor = Color.WHITE,
            descriptionColor = Color.WHITE,
            titleTypefaceFontRes = R.font.sh,
            descriptionTypefaceFontRes = R.font.sh,
        ))


        addSlide(AppIntroFragment.newInstance(
            title = "CLEAR RESULTS",
            description = "GET SINGLE WEBSITE RESULTS AS WELL AS THE OVERALL RESULT IN NO TIME",
            imageDrawable = R.drawable.nowmakef,
            backgroundDrawable = R.drawable.sawwe,
            titleColor = Color.BLACK,
            descriptionColor = Color.BLACK,
            titleTypefaceFontRes = R.font.sh,
            descriptionTypefaceFontRes = R.font.sh,
        ))

        addSlide(AppIntroFragment.newInstance(
            title = "COMPARE ANYWHERE",
            description = "MAKE YOUR COMPARISIONS ANYWHERE AND GET THE BEST DEAL FOR YOUR BUCKS",
            imageDrawable = R.drawable.raina,
            backgroundDrawable = R.drawable.scaw,
            titleColor = Color.WHITE,
            descriptionColor = Color.WHITE,
            titleTypefaceFontRes = R.font.sh,
            descriptionTypefaceFontRes = R.font.sh,

        ))
        setTransformer(AppIntroPageTransformerType.Fade)

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(R.anim.rei,R.anim.rey)
        finish()

    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(R.anim.rei,R.anim.rey)
        finish()
    }

}
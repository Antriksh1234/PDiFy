package com.atandroidlabs.pdify

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView

class SplashScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val appNameTextView: TextView = findViewById(R.id.app_name_textView)
        val appThemeImageView: ImageView = findViewById(R.id.app_theme_image)

        //Setting up the ImageView and TextView for the animation
        appNameTextView.alpha = 0F
        appThemeImageView.alpha = 0F
        appNameTextView.translationY = 400F
        appThemeImageView.translationY = 400F

        //Performing actual animation on the TextView and ImageView
        appNameTextView.animate().alpha(1F).translationYBy(-400F).duration = 700
        appThemeImageView.animate().alpha(1F).translationYBy(-400F).duration = 700

        //Launching MainActivity using handler after a delay of 5 seconds
        val handler: Handler = Handler()

        handler.postDelayed(Runnable {
            val intent: Intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}
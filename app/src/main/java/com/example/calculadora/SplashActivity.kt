package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.calculadora.databinding.ActivityMainBinding
import com.example.calculadora.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var splashActivityMainBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashActivityMainBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashActivityMainBinding.root
        setContentView(view)

        splashScreen.setKeepOnScreenCondition{true}

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}
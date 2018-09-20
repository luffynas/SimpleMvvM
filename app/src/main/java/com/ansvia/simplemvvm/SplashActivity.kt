package com.ansvia.simplemvvm

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.ansvia.simplemvvm.ui.Mode
import com.ansvia.simplemvvm.ui.PostActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            PostActivity.startThisActivity(this, Mode.LIST)
        }, 1000)
    }
}

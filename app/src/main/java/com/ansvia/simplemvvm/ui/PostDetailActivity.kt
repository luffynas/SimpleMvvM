package com.ansvia.simplemvvm.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ansvia.simplemvvm.R

class PostDetailActivity : AppCompatActivity() {

    companion object {
        fun startThisActivity(context: Context){
            val intent = Intent(context, PostActivity::class.java)
            (context).startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
    }
}

package com.ansvia.simplemvvm.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import com.ansvia.simplemvvm.R


abstract class BaseActivity : AppCompatActivity(), Interaction {

    /**
     * Variable
     */
    private var mView: View? = null

    private var fabView: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        mView = findViewById<FrameLayout>(R.id.content)
    }

    protected fun addFragment(fragment: Fragment){
        supportFragmentManager
                .beginTransaction()
                .add(R.id.content, fragment, fragment.tag)
                //.disallowAddToBackStack()
                .commit()
    }

    @SuppressLint("RestrictedApi")
    protected fun initFab(use: Boolean){
        if (use) {
            fabView = findViewById(R.id.fab)
            fabView?.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item?.itemId){
//            R.id.itemCreate -> Log.d("PostEntity", "Hello")
//        }
        return super.onOptionsItemSelected(item)
    }

    override fun getFab(): FloatingActionButton {
        if (fabView != null)
            return fabView as FloatingActionButton
        throw RuntimeException("fab not implement, please use initFab()")
    }
}

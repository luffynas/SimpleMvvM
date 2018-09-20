package com.ansvia.simplemvvm.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ansvia.simplemvvm.R
import com.ansvia.simplemvvm.ui.fragment.PostCreatedFragment
import com.ansvia.simplemvvm.ui.fragment.PostListFragment


class PostActivity : BaseActivity() {

    companion object {
        fun startThisActivity(context: Context, mode: Mode){
            val intent = Intent(context, PostActivity::class.java)
            intent.putExtra("mode", mode)
            (context).startActivity(intent)
        }
    }

    /**
     * Variable
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mode = intent.getSerializableExtra("mode") as Mode
        when(mode){
            Mode.LIST -> {
                initFab(true)
                title = getString(R.string.post_list)
                addFragment(PostListFragment())
            }
            Mode.INSERT -> {
                title = getString(R.string.post_created)
                addFragment(PostCreatedFragment())
            }
            Mode.DETAIL -> {
                title = getString(R.string.post_detail)
                PostDetailActivity.startThisActivity(this)
            }
            else -> {
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.itemCreate -> Log.d("PostEntity", "Hello")
        }
        return super.onOptionsItemSelected(item)
    }
}

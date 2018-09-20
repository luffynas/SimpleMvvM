package com.ansvia.simplemvvm.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansvia.simplemvvm.R
import com.ansvia.simplemvvm.ui.Mode
import com.ansvia.simplemvvm.db.entity.PostEntity
import com.ansvia.simplemvvm.ui.PostActivity
import com.ansvia.simplemvvm.ui.adapter.PostAdapter
import com.ansvia.simplemvvm.viewmodel.PostViewModel


class PostListFragment : BaseFragment(), View.OnClickListener {

    private var postAdapter: PostAdapter? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var posts: MutableList<PostEntity> = ArrayList()

    private val recyclerView by lazy { mView!!.findViewById<RecyclerView>(R.id.recyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getPosts().observe(this, Observer {
            Log.d("observe", "observer")
            it?.map {
                Log.d("observe2", "observer ${it.body}")
                posts.add(it)
                postAdapter?.notifyDataSetChanged()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflateView(context!!, inflater, container!!, R.layout.activity_post)

        linearLayoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = linearLayoutManager

        postAdapter = PostAdapter(context, posts)
        recyclerView?.adapter = postAdapter
        postAdapter?.notifyDataSetChanged()

//        init()

        fab.setOnClickListener(this)

        return mView
    }

//    private fun init(){
//        for (index in 0..20){
//            val post = PostEntity("", "Unit: $index", "Unit in Kotlin $index")
//            posts.add(post)
//        }
//
//        postAdapter?.notifyDataSetChanged()
//    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.fab -> { PostActivity.startThisActivity(context!!, Mode.INSERT) }
        }
    }
}

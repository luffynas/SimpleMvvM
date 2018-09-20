package com.ansvia.simplemvvm.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ansvia.simplemvvm.R
import com.ansvia.simplemvvm.db.entity.PostEntity
import com.ansvia.simplemvvm.viewmodel.PostViewModel


class PostCreatedFragment : BaseFragment(), View.OnClickListener {

    private val inputBody by lazy { mView?.findViewById<TextInputEditText>(R.id.inputBody) }
    private val btnCreatePost by lazy { mView?.findViewById<Button>(R.id.btnCreatePost) }

    private var postViewModel: PostViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflateView(context!!, inflater, container!!, R.layout.fragment_post_created)

        btnCreatePost?.setOnClickListener(this)
        return mView
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnCreatePost -> { postNow() }
        }
    }

    private fun postNow(){
        //insert into db
        val body = inputBody?.text.toString()
        val postEntity = PostEntity("", "Tile $body", body)
        postViewModel?.insert(postEntity)
        activity?.finish()
    }
}

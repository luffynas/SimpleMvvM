package com.ansvia.simplemvvm.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ansvia.simplemvvm.R
import com.ansvia.simplemvvm.db.entity.PostEntity

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
class PostAdapter(val context: Context?, val posts: List<PostEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(posts[position])
    }

    private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title by lazy { itemView.findViewById<TextView>(R.id.txtTitle) }
        private val body by lazy { itemView.findViewById<TextView>(R.id.txtBody) }

        fun bind(post: PostEntity){
            title.text  = post.title
            body.text  = post.body
        }
    }
}
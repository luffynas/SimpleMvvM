package com.ansvia.simplemvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.ansvia.simplemvvm.data.PostRepository
import com.ansvia.simplemvvm.db.AppDatabases
import com.ansvia.simplemvvm.db.entity.PostEntity

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
class PostViewModel(application: Application) : AndroidViewModel(application) {

    private var postRepository: PostRepository
    private var liveUserData: LiveData<List<PostEntity>>

    init {
        val appDatabases = AppDatabases.getInstance(application)
        this.postRepository = PostRepository.getInstance(appDatabases)
        this.liveUserData = postRepository.getPosts()
    }

    public fun getPosts(): LiveData<List<PostEntity>>{
        return liveUserData
    }

    public fun insert(postEntity: PostEntity){
        postRepository.insert(postEntity)
    }

}
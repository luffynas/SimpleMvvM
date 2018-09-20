package com.ansvia.simplemvvm.data

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.ansvia.simplemvvm.db.AppDatabases
import com.ansvia.simplemvvm.db.dao.PostDao
import com.ansvia.simplemvvm.db.entity.PostEntity

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
class PostRepository(private var appDatabases: AppDatabases) {

    companion object {
        private var singleton: PostRepository? = null

        fun getInstance(appDatabases: AppDatabases): PostRepository {
            if (singleton == null) {
                synchronized(PostRepository::class.java) {
                    if (singleton == null) {
                        singleton = PostRepository(appDatabases)
                    }
                }
            }
            return singleton!!
        }

        fun removeInstance(){
            if (singleton != null)
                singleton = null
        }
    }
    //===============================================


    private val postDao: PostDao = appDatabases.getPostDao()
    private val postLiveData: LiveData<List<PostEntity>> = postDao.getAll()

    public fun getPosts(): LiveData<List<PostEntity>>{
        return postLiveData
    }

    public fun insert(postEntity: PostEntity){
        asyncInsertPost(postDao).execute(postEntity)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class asyncInsertPost(val postDao: PostDao) : AsyncTask<PostEntity, Void, Unit>() {

        override fun doInBackground(vararg params: PostEntity?) {
            postDao.inserts(params[0]!!)
            return
        }

    }

}
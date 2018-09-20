package com.ansvia.simplemvvm.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ansvia.simplemvvm.db.entity.PostEntity

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
@Dao
interface PostDao {

    @Query("SELECT * FROM postentity")
    fun getAll(): LiveData<List<PostEntity>>

//    @Query("SELECT * FROM postentity where title = :title LIMIT 1")
//    fun findByName(title: String): LiveData<PostEntity>

    @Insert
    fun inserts(vararg person: PostEntity)

    @Delete
    fun delete(postEntity: PostEntity)
}
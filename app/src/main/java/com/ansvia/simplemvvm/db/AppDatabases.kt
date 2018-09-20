package com.ansvia.simplemvvm.db

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import com.ansvia.simplemvvm.db.dao.PostDao
import com.ansvia.simplemvvm.db.entity.PostEntity

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
private const val DATABASE = "social-data"

@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabases : RoomDatabase() {

    abstract fun getPostDao(): PostDao

    companion object {
        private var singleton: AppDatabases? = null

        fun getInstance(application: Application): AppDatabases {
            if (singleton == null) {
                synchronized(AppDatabases::class.java) {
                    if (singleton == null) {
                        singleton = buildDatabase(application)
                    }
                }
            }
            return singleton!!
        }

        private fun buildDatabase(application: Application): AppDatabases {

            return Room.databaseBuilder(application, AppDatabases::class.java, DATABASE).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.d("%s already use", DATABASE)
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    Log.d("%s is Open", DATABASE)
                }
            }).build()
        }
    }
}
package com.ansvia.simplemvvm.db.entity

import android.arch.persistence.room.*

/**
 * Created by M. Nashrulloh on 19/09/18.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
@Entity(tableName = "postentity")
class PostEntity {
    @PrimaryKey(autoGenerate = true)
    var uid : Int = 0

    @ColumnInfo(name = "picture")
    var picture: String = ""

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "username")
    var body: String = ""

    constructor(picture: String, title: String, body: String) {
        this.picture = picture
        this.title = title
        this.body = body
    }
}
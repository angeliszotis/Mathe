package com.example.mathapp.framework.result.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result")
open class ResultUnit1Entity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    open var id: Long = 0,

    @ColumnInfo(name = "name")
    var name: String? = "name",

    @ColumnInfo(name = "surname")
    var surname: String? = "surname",

    @ColumnInfo(name = "school")
    var school: String? = "school",

    @ColumnInfo(name = "correct")
    var correct: String? = null,

    @ColumnInfo(name = "incorrect")
    var incorrect: String? = null,

    @ColumnInfo(name = "time")
    var time: String? = null
)
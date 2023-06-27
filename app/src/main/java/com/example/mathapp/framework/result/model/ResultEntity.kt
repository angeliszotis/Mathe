package com.example.mathapp.framework.result.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result")
data class ResultEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long=0,

    @ColumnInfo(name = "name")
    var name: String = "name",

    @ColumnInfo(name = "surname")
    var surname: String = "surname",

    @ColumnInfo(name = "school")
    var school: String = "school",

    @ColumnInfo(name = "corect")
    var correct: String,

    @ColumnInfo(name = "incorect")
    var incorrect: String,

    @ColumnInfo(name = "time")
    var time: String
)
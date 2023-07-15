package com.example.mathapp.framework.result.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "unit2")
data class ResultUnit2Entity(

@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")
var id: Long = 0,

@ColumnInfo(name = "name")
var name: String = "name",

@ColumnInfo(name = "surname")
var surname: String = "surname",

@ColumnInfo(name = "school")
var school: String = "school",

@ColumnInfo(name = "correct")
var correct: String,

@ColumnInfo(name = "incorrect")
var incorrect: String,

@ColumnInfo(name = "time")
var time: String
)
package com.example.mathapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String="",

    @ColumnInfo(name = "surname")
    var surname: String="",

    @ColumnInfo(name = "school")
    var school: String="",
)
package com.beyzaakkuzu.mvvmtodolistapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
class Todo(
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="description")
    var description: String,
    @PrimaryKey var id:Int? = 0
)
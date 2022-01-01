package com.beyzaakkuzu.mvvmtodolistapp.domain.repository

import com.beyzaakkuzu.mvvmtodolistapp.data.data_source.TodoDatabase
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo

class TodoRepository(private val db:TodoDatabase) {

    suspend fun insert(item: Todo)= db.getTodoDao().insert(item)

    suspend fun delete(item: Todo)= db.getTodoDao().delete(item)

    fun getAllTodoItems()= db.getTodoDao().getAllTodoItems()
}
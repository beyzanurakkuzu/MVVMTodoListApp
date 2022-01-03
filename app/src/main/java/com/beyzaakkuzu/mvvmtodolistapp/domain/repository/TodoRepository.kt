package com.beyzaakkuzu.mvvmtodolistapp.domain.repository

import com.beyzaakkuzu.mvvmtodolistapp.data.data_source.TodoDatabase
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo

class TodoRepository(private val db:TodoDatabase) {

    suspend fun insert(items: Todo)= db.getTodoDao().insert(items)

    suspend fun delete(items: Todo)= db.getTodoDao().delete(items)

    fun getAllTodoItems()= db.getTodoDao().getAllTodoItems()
}
package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import androidx.lifecycle.ViewModel
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo
import com.beyzaakkuzu.mvvmtodolistapp.domain.repository.TodoRepository
import kotlinx.coroutines.*

class TodoViewModel(private val repository: TodoRepository
): ViewModel() {

    fun insert(items: Todo)= CoroutineScope(Dispatchers.Main).launch {
        repository.insert(items)
    }
    fun delete(items:Todo)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(items)
    }
    fun getAllTodoItems() = repository.getAllTodoItems()
}


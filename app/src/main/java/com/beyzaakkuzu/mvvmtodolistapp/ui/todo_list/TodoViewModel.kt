package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import androidx.lifecycle.ViewModel
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo
import com.beyzaakkuzu.mvvmtodolistapp.domain.repository.TodoRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository
): ViewModel() {
    fun insert(item: Todo)= GlobalScope.launch {
        repository.insert(item)
    }
    fun delete(item: Todo)= GlobalScope.launch {
        repository.delete(item)
    }
    fun getAllTodoItems() = repository.getAllTodoItems()
}
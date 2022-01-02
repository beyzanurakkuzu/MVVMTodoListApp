package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.beyzaakkuzu.mvvmtodolistapp.domain.repository.TodoRepository
@Suppress("UNCHECKED_CAST")
class TodoViewModelFactory (private val repository: TodoRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}
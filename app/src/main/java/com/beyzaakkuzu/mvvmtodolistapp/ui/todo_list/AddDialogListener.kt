package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo

interface AddDialogListener {
    fun onAddButtonClicked(item: Todo)
}
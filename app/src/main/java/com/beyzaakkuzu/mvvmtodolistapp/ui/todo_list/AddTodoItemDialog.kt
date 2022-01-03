package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.beyzaakkuzu.mvvmtodolistapp.R
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo
import kotlinx.android.synthetic.main.add_dialog_todo_item.*


class AddTodoItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context)
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_dialog_todo_item)

        add_tv.setOnClickListener {
            val title= titleEt.text.toString()
            val description=descEt.text.toString()
            if(title.isEmpty()){
                Toast.makeText(context, "Please enter title the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val items= Todo(title, description)
            addDialogListener.onAddButtonClicked(items)
            dismiss()
        }
        cancel_tv.setOnClickListener {
            cancel()
        }

    }
}

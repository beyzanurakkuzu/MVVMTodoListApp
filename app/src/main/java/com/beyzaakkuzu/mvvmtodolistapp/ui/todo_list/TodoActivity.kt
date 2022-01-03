package com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyzaakkuzu.mvvmtodolistapp.R
import com.beyzaakkuzu.mvvmtodolistapp.adapter.TodoItemAdapter
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo
import kotlinx.android.synthetic.main.activity_todo.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class TodoActivity() : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: TodoViewModelFactory by instance()


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val viewModel = ViewModelProvider(this, factory)[TodoViewModel::class.java]

        val adapter= TodoItemAdapter(listOf(),viewModel)
        rvTodoItems.layoutManager= LinearLayoutManager(this)
        rvTodoItems.adapter= adapter
        viewModel.getAllTodoItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            AddTodoItemDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(items: Todo) {
                    viewModel.insert(items)
                }

            }).show()
        }



    }
}


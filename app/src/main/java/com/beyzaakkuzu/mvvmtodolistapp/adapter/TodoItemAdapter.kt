package com.beyzaakkuzu.mvvmtodolistapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyzaakkuzu.mvvmtodolistapp.R
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo
import com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list.TodoViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoItemAdapter (var items: List<Todo>,
                       private val viewModel: TodoViewModel
) : RecyclerView.Adapter<TodoItemAdapter.TodoViewHolder>()
     {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
            return TodoViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            val curTodoItem= items[position]
            holder.itemView.nameTextView.text = curTodoItem.title
            holder.itemView.descTextView.text = curTodoItem.description


            holder.itemView.delete.setOnClickListener {
                viewModel.delete(curTodoItem)
            }

        }

        inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    }

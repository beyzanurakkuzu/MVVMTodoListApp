package com.beyzaakkuzu.mvvmtodolistapp.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.beyzaakkuzu.mvvmtodolistapp.domain.model.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(items: Todo)

    @Delete
    suspend fun delete(items: Todo)

    @Query("SELECT * FROM todo_items" )
    fun getAllTodoItems(): LiveData<List<Todo>>
}
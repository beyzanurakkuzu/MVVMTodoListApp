package com.beyzaakkuzu.mvvmtodolistapp

import android.app.Application
import com.beyzaakkuzu.mvvmtodolistapp.data.data_source.TodoDatabase
import com.beyzaakkuzu.mvvmtodolistapp.domain.repository.TodoRepository
import com.beyzaakkuzu.mvvmtodolistapp.ui.todo_list.TodoViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class TodoApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@TodoApplication))
        bind() from singleton { TodoDatabase(instance()) }
        bind() from singleton { TodoRepository(instance()) }
        bind() from provider {
            TodoViewModelFactory(instance())
        }
    }

}
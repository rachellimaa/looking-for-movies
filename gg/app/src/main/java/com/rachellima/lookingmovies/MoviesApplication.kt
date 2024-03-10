package com.rachellima.lookingmovies

import android.app.Application
import androidx.room.Room
import com.rachellima.database.AppDatabase
import com.rachellima.lookingmovies.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MoviesApplication : Application() {
    private var database: AppDatabase? = null
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MoviesApplication)
            modules(
                appModule, databaseModule
            )
        }

        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "application-db")
                .allowMainThreadQueries().build()


    }
    private val databaseModule = module {
        single { database?.searchDao() }
    }
}
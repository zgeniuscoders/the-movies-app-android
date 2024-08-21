package cd.zgeniuscoders.themoviesapp.common

import android.app.Application
import cd.zgeniuscoders.themoviesapp.movies.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(applicationContext)
            modules(
                moviesModule
            )
        }
    }
}
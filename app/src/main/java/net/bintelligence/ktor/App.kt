package net.bintelligence.ktor

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import net.bintelligence.ktor.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application(){//MultiDexApplication
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule, dataModule, domainModule)
        }
    }
}
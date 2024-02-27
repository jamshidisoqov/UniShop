package uz.uni_team.uni_shop

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import uz.uni_team.registration.di.registrationModule
import uz.uni_team.uni_shop.di.appModule

class UniShopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            //module
            modules(appModule, registrationModule)
        }
    }

}
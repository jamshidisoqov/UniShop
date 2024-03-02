package uz.uni_team.uni_shop

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import uz.uni_team.data.di.networkModule
import uz.uni_team.data.di.repositoryModule
import uz.uni_team.data.di.serviceModule
import uz.uni_team.domain.di.domainModule
import uz.uni_team.registration.di.registrationModule
import uz.uni_team.uni_shop.di.appModule
import uz.uni_team.warehouse.di.wareHouseModule

class UniShopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            //module
            modules(
                appModule,
                registrationModule,
                domainModule,
                repositoryModule,
                serviceModule,
                networkModule,
                wareHouseModule
            )
        }
    }

}
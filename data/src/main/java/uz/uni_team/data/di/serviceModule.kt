package uz.uni_team.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uni_team.data.network.service.AuthService
import uz.uni_team.data.network.service.AuthServiceImpl

val serviceModule = module {
    singleOf(::AuthServiceImpl) bind AuthService::class
}
package uz.uni_team.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module
import uz.uni_team.data.network.common.contentNegotiation
import uz.uni_team.data.network.common.defaultRequest
import uz.uni_team.data.network.common.httpTimeOutConfig

val networkModule = module {
    single<HttpClient> {
        HttpClient(CIO) {
            httpTimeOutConfig()
            defaultRequest()
            contentNegotiation()
        }
    }
}
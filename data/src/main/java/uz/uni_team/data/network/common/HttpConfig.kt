package uz.uni_team.data.network.common

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout

internal fun HttpClientConfig<*>.httpTimeOutConfig() {
    install(HttpTimeout) {
        requestTimeoutMillis = 30000
        connectTimeoutMillis = 30000
        socketTimeoutMillis = 30000
    }
}
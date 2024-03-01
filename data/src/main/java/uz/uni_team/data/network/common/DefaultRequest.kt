package uz.uni_team.data.network.common

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.header
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import uz.uni_team.data.BuildConfig


private const val HEADER_SELECTED_LANGUAGE: String = "language"
private const val HEADER_AUTHORIZATION: String = "Authorization"


internal fun HttpClientConfig<*>.authDefaultRequest(token: String) = install(DefaultRequest) {
    url.protocol = URLProtocol.HTTPS
    url.withBaseUrl(BuildConfig.BASE_URL)
    header(HEADER_AUTHORIZATION, "Bearer $token")
    header(HEADER_SELECTED_LANGUAGE, "UZ")
}
internal fun HttpClientConfig<*>.defaultRequest() = install(DefaultRequest) {
    url.protocol = URLProtocol.HTTPS
    url.withBaseUrl(BuildConfig.BASE_URL)
    header(HEADER_SELECTED_LANGUAGE, "UZ")
}

private fun URLBuilder.withBaseUrl(url: String): URLBuilder {
    val baseUrl = Url(url)
    val urlBuilder = URLBuilder(baseUrl).apply { encodedPath += this@withBaseUrl.encodedPath }
    return takeFrom(urlBuilder)
}
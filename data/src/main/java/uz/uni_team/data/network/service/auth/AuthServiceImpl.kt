package uz.uni_team.data.network.service.auth

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import uz.uni_team.data.model.remote.auth.AuthRequest

internal class AuthServiceImpl(private val client: HttpClient) : AuthService {
    override suspend fun registerUser(authRequest: AuthRequest) {
        println("Registered user :${authRequest.phone} :${authRequest.password}")
        client.post("/api/v1/register-user") {
            setBody(authRequest)
        }
    }
}
package uz.uni_team.data.network.service.auth

import uz.uni_team.data.model.remote.auth.AuthRequest

interface AuthService {

    suspend fun registerUser(authRequest: AuthRequest)

}
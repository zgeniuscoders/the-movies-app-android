package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.users.domain.entities.UserEntity
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.User
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class LoginUseCase(private val userServices: UserService) {

    suspend fun run(loginRequest: LoginRequest): UserEntity? {
        return userServices.login(loginRequest)
    }

}
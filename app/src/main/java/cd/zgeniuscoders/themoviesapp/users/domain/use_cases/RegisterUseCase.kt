package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class RegisterUseCase(
    private val userServices: UserService
) {

    suspend fun run(registerRequest: RegisterRequest) {
        userServices.register(registerRequest)
    }

}
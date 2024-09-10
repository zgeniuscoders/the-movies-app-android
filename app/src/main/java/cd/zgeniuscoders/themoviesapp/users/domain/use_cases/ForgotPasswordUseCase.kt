package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ForgotPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class ForgotPasswordUseCase(
    private val userService: UserService
) {

    suspend fun run(request: ForgotPasswordRequest) {
        return userService.forgotPassword(request)
    }

}
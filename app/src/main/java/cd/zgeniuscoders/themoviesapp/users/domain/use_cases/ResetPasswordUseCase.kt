package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ResetPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class ResetPasswordUseCase(
    private val userService: UserService
) {

    suspend fun run(request: ResetPasswordRequest) {
        return userService.resetPassword(request)
    }

}
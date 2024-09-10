package cd.zgeniuscoders.themoviesapp.users.domain.use_cases

import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class UserInteractor private constructor(
    val loginUseCase: LoginUseCase,
    val registerUseCase: RegisterUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase,
    val forgotPasswordUseCase: ForgotPasswordUseCase,
    val saveUserPref: SaveUserPref
) {
    companion object {
        fun build(service: UserService): UserInteractor {
            return UserInteractor(
                LoginUseCase(service),
                RegisterUseCase(service),
                ResetPasswordUseCase(service),
                ForgotPasswordUseCase(service),
                SaveUserPref(service)
            )
        }
    }
}
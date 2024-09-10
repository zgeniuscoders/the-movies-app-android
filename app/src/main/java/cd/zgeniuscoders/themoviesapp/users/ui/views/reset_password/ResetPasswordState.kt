package cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password

data class ResetPasswordState(
    val password: String = "",
    val confirmPassword: String = "",
    val hasFormError: Boolean = false,
    val error: String = "",
    val isFormValidated: Boolean = false
)
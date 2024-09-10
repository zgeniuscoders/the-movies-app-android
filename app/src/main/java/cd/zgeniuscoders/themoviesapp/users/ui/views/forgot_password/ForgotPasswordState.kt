package cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password

data class ForgotPasswordState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val hasFormError: Boolean = false,
    val error: String = "",
    val isFormValidated: Boolean = false
)
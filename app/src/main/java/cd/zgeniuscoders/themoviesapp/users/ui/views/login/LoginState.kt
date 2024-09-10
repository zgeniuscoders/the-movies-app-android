package cd.zgeniuscoders.themoviesapp.users.ui.views.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val hasFormError: Boolean = false,
    val error: String = "",
    val isFormValidated: Boolean = false,
    val isLogged: Boolean = false,
    val showPassword: Boolean = true,
)
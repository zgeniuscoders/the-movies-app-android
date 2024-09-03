package cd.zgeniuscoders.themoviesapp.users.ui.views.register

data class RegisterState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val hasFormError: Boolean = false,
    val error: String = "",
    val errors: HashMap<String, List<String>>? = null,
    val isFormValidated: Boolean = false

)
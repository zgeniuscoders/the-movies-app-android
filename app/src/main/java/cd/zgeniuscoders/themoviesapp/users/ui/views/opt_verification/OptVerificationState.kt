package cd.zgeniuscoders.themoviesapp.users.ui.views.opt_verification

data class OptVerificationState(
    val code: String = "",
    val isValidated: Boolean = false,
    val hasError: Boolean = true,
    val error: String = ""
)

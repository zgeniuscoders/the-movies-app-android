package cd.zgeniuscoders.themoviesapp.users.domain.models.Request

data class LoginRequest(
    val email: String,
    val password: String
)
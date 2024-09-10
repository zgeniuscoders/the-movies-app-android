package cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password

sealed class ForgotPasswordEvent {
    data class OnEmailChanged(val value: String) : ForgotPasswordEvent()
    data object OnFormSubmitted : ForgotPasswordEvent()
}
package cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password

sealed class ResetPasswordEvent {
    data class OnPasswordChanged(val value: String) :ResetPasswordEvent()
    data class OnConfirmPasswordChanged(val value: String) :ResetPasswordEvent()
    data object OnFormSubmitted: ResetPasswordEvent()
}
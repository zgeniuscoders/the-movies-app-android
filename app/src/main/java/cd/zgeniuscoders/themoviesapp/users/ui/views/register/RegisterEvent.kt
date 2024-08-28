package cd.zgeniuscoders.themoviesapp.users.ui.views.register

sealed class RegisterEvent {
    data class OnEmailChanged(val value: String) : RegisterEvent()
    data class OnUsernameChanged(val value: String) : RegisterEvent()
    data class OnPasswordChanged(val value: String) : RegisterEvent()
    data class OnConfirmPasswordChanged(val value: String) : RegisterEvent()
    data object OnFormSubmitted: RegisterEvent()
}
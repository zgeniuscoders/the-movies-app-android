package cd.zgeniuscoders.themoviesapp.users.ui.views.login

sealed class LoginEvent {
    data class OnEmailChanged(val value: String) : LoginEvent()
    data class OnPasswordChanged(val value: String) : LoginEvent()
    data class OnRememberMeChanged(val value: Boolean) : LoginEvent()
    data object OnFormSubmitted : LoginEvent()
}
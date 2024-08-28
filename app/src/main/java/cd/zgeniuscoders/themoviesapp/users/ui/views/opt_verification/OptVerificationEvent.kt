package cd.zgeniuscoders.themoviesapp.users.ui.views.opt_verification

sealed class OptVerificationEvent {
    data class OnCodeChanged(val value: String) : OptVerificationEvent()
    data object OnSubmitted : OptVerificationEvent()
}
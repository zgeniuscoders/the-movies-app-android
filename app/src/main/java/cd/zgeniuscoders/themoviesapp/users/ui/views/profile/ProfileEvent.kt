package cd.zgeniuscoders.themoviesapp.users.ui.views.profile

sealed class ProfileEvent {
    data object OnLogout: ProfileEvent()
}
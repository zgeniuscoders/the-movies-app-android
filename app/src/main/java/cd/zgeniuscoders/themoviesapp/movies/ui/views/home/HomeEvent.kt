package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

sealed class HomeEvent {
    data class OnCategoryChange(val value: String): HomeEvent()
}
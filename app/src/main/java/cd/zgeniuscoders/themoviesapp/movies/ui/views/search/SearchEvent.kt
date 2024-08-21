package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

sealed class SearchEvent {
    data class OnSearchChanged(val value: String): SearchEvent()
}
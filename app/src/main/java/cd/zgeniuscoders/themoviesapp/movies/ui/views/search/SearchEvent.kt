package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

sealed class SearchEvent {
    data object OnSearchChanged: SearchEvent()
}
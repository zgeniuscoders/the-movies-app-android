package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

data class HomeState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val categories: List<Category> = emptyList(),
    val selectedCategory: String = "all",
    val error: Throwable? = null,
    val originMoviesList: List<Movie> = emptyList(),
)
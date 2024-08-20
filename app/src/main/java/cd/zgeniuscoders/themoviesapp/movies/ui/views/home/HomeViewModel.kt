package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.CategoryInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieInteractor


class HomeViewModel(
    private val movieInteractor: MovieInteractor,
    private val categoryInteractor: CategoryInteractor
) :
    ViewModel() {

    var state by mutableStateOf(HomeState())

    suspend fun getMovies() {

        val movies = movieInteractor.getMovies.run()
        state = state.copy(movies = movies)

    }

    suspend fun getCategories() {

        val categories = categoryInteractor.getCategories.run()
        state = state.copy(categories = categories)

    }

}
package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.CategoryInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieInteractor
import kotlinx.coroutines.launch


class HomeViewModel(
    private val movieInteractor: MovieInteractor,
    private val categoryInteractor: CategoryInteractor
) :
    ViewModel() {

    var state by mutableStateOf(HomeState())


    fun onTriggerEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnCategoryChange -> handlerCategoryChanged(event.value)
        }
    }

    private fun handlerCategoryChanged(category: String){

        viewModelScope.launch {

            val initialMovies = state.originMoviesList

            val filteredMovies = if (category.lowercase() == "all") {
                initialMovies
            } else {
                initialMovies.filter { it.category.lowercase() == category.lowercase() }
            }

            state = state.copy(movies = filteredMovies)

        }

    }


    suspend fun getMovies() {

        val movies = movieInteractor.getMovies.run()
        state = state.copy(movies = movies, originMoviesList = movies, isLoading = false)

    }

    suspend fun getCategories() {

        val categories = categoryInteractor.getCategories.run()
        state = state.copy(categories = categories)

    }

}
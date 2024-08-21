package cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieDaoInteractor

class FavoriteViewModel(
    private val movieInteractor: MovieDaoInteractor
) : ViewModel() {


    var state by mutableStateOf(FavoriteState())

    fun onTriggerEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.OnSearchChanged -> {
                // Handle search event
            }
        }
    }


    suspend fun getFavoriteMovies() {
        val movies = movieInteractor.getMovies.run()
        state = state.copy(movies = movies)
    }


}
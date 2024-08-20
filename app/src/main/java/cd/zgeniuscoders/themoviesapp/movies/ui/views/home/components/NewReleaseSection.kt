package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.zgeniuscoders.themoviesapp.common.routes.DetailRoute
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

@Composable
fun NewReleaseSection(navHostController: NavHostController, movies: List<Movie>) {

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {

        Listings(title = "New Release", movies = movies, onMovieSelected = { movie ->
            navHostController.navigate(
                DetailRoute(
                    movie = movie
                )
            )
        })
    }
}

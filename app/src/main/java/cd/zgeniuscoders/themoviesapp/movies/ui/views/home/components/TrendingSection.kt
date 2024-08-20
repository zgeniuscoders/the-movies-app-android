package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

@Composable
fun TrendingSection(navHostController: NavHostController, movies: List<Movie>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {

        Listings(title = "Trending", movies = movies,navHostController = navHostController)
    }
}
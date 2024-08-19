package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movies

@Composable
fun Listings(
    title: String,
    movies: List<Movies>,
    onclick: () -> Unit = {},
    navHostController: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            "See all",
            style = MaterialTheme.typography.bodySmall,
            color = green,
            modifier = Modifier.clickable { onclick() }
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    movies.shuffled()

    LazyRow {
        items(movies.size) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable {
                        navHostController.navigate(Route.detail.route)
                    }
            ) {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = movies[it].cover),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    movies[it].title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
        }
    }
}
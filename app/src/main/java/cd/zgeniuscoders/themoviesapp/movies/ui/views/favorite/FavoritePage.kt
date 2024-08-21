package cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.common.routes.DetailRoute
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritePage(navHostController: NavHostController) {
    val vm = koinViewModel<FavoriteViewModel>()
    val onEvent = vm::onTriggerEvent

    LaunchedEffect(Unit) {
        vm.getFavoriteMovies()
    }

    FavoriteBody(navHostController, vm.state)
}

@Composable
fun FavoriteBody(navHostController: NavHostController, state: FavoriteState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        item {
            Text(
                "My Favorites movies",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(10.dp)
            )
        }

        item {
            TextFieldComponent(
                modifier = Modifier.padding(10.dp),
                textValue = "",
                label = "Recherche...",
                keyboardType = KeyboardType.Text,
                shape = RoundedCornerShape(50.dp),
                content = {
                    Icon(Icons.Rounded.Search, contentDescription = "search icon")
                }) {

            }
        }

        if (state.movies.isNotEmpty()) {
            items(state.movies.size) {
                val movie = state.movies[it]
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable {
                            navHostController.navigate(
                                DetailRoute(
                                    movie = movie
                                )
                            )
                        },
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(220.dp)
                    ) {
                        Image(
                            painter = painterResource(id = movie.posterPath),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            movie.title, style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            movie.synopsis,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text("Release Date")
                        Text(
                            movie.releaseDate,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        } else {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "No favorite movies found.",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun FavoritePreview(modifier: Modifier = Modifier) {
    FavoriteBody(navHostController = rememberNavController(), state = FavoriteState())
}
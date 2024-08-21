package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.common.routes.DetailRoute
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchPage(navHostController: NavHostController) {
    val vm = koinViewModel<SearchViewModel>()
    val event = vm::onTriggerEvent

    LaunchedEffect(Unit) {
        vm.getMovies()
    }

    SearchBody(vm.state,event,navHostController)
}

@Composable
fun SearchBody(
    state: SearchState,
    event: (event: SearchEvent) -> Unit = {},
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            "Find Movies, Series \n" +
                    "And More",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp)
        )


        TextFieldComponent(
            modifier = Modifier.padding(10.dp),
            textValue = state.search,
            label = "Recherche...",
            keyboardType = KeyboardType.Text,
            shape = RoundedCornerShape(50.dp),
            onValueChange = {
                event(SearchEvent.OnSearchChanged(it))
            },
            content = {
                Icon(Icons.Rounded.Search, contentDescription = "search icon")
            })


//        CategorySection()


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.movies.size) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .clickable {
                            navHostController.navigate(
                                DetailRoute(
                                    movie = state.movies[it]
                                )
                            )
                        }
                ) {
                    Card {
                        Image(
                            painter = painterResource(id = state.movies[it].posterPath),
                            contentDescription = null
                        )
                    }
                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun SearchPreview(modifier: Modifier = Modifier) {
    SearchBody(SearchState(), navHostController = rememberNavController())
}
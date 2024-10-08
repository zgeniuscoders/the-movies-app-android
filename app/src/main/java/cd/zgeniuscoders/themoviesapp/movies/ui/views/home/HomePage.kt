package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.CategorySection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.HeadSection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.NewReleaseSection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.TrendingSection
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomePage(navHostController: NavHostController) {
    val vm = koinViewModel<HomeViewModel>()
    val onEvent = vm::onTriggerEvent

    LaunchedEffect(Unit) {
        vm.getMovies()
        vm.getCategories()
    }


    HomeBody(navHostController, vm.state,onEvent)
}

@Composable
fun HomeBody(
    navHostController: NavHostController,
    state: HomeState,
    onEvent: (event: HomeEvent) -> Unit = {}
) {
    if(state.isLoading){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Column {
                    HeadSection()
                }
            }

            item {
                CategorySection(state.categories,onEvent)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                NewReleaseSection(navHostController, state.movies)
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                TrendingSection(navHostController, state.movies)
            }

            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Surface {
        HomeBody(rememberNavController(), HomeState())
    }
}
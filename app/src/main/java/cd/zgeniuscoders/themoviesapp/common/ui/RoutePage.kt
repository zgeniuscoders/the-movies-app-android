package cd.zgeniuscoders.themoviesapp.common.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.components.BottomBar
import cd.zgeniuscoders.themoviesapp.movies.ui.views.details.DetailPage
import cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite.FavoritePage
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.HomePage
import cd.zgeniuscoders.themoviesapp.movies.ui.views.search.SearchPage

@Composable
fun RoutePage(navHostController: NavHostController) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val mainPages = listOf(
        Route.homepage.route,
        Route.search.route,
        Route.favorite.route,
        Route.profile.route
    )

    Scaffold(
        bottomBar = {
            if(currentRoute in mainPages){
                BottomBar(navHostController)
            }
        }
    ) { innerP ->
        NavHost(
            navController = navHostController,
            startDestination = Route.homepage.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerP)
        ) {
            composable(route = Route.homepage.route){
                HomePage(navHostController)
            }

            composable(route = Route.search.route){
                SearchPage()
            }

            composable(route = Route.favorite.route){
                FavoritePage(navHostController)
            }

            composable(route = Route.detail.route){
                DetailPage(navHostController)
            }
        }
    }
}
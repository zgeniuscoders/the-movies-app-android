package cd.zgeniuscoders.themoviesapp.common.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        BottomItem(
            title = "Movies",
            selectedIcon = Icons.Rounded.Tv,
            unselectedIcon = Icons.Outlined.Tv,
            route = Route.homepage.route
        ),
        BottomItem(
            title = "Search",
            selectedIcon = Icons.Rounded.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = Route.search.route
        ),
        BottomItem(
            title = "Favoris",
            selectedIcon = Icons.Rounded.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            route = Route.favorite.route
        ),
        BottomItem(
            title = "Profile",
            selectedIcon = Icons.Rounded.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = Route.profile.route
        ),
    )

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    BottomAppBar {
        items.forEachIndexed { index, bottomItem ->

            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(bottomItem.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = green
                ),
                icon = {
                    Icon(
                        imageVector = if (selectedItem == index) {
                            bottomItem.selectedIcon
                        } else {
                            bottomItem.unselectedIcon
                        }, contentDescription = bottomItem.title
                    )
                }
            )

        }
    }
}

data class BottomItem(
    var title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    var route: String
)
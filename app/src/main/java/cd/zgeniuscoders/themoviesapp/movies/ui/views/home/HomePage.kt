package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    HomeBody()
}

@Composable
fun HomeBody() {

}

@Composable
fun HomePreview() {
    Surface {
        HomePage()
    }
}
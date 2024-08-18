package cd.zgeniuscoders.themoviesapp.movies.ui.views.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.CategorySection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.HeadSection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.NewReleaseSection
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.TrendingSection

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    HomeBody()
}

@Composable
fun HomeBody() {
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
            CategorySection()
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            NewReleaseSection()
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            TrendingSection()
        }

        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Surface {
        HomePage()
    }
}
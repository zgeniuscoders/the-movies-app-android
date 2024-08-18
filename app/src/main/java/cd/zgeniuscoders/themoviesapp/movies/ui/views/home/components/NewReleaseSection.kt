package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movies

@Composable
fun NewReleaseSection(modifier: Modifier = Modifier) {

    val movies = listOf(
        Movies(
            "nightbooks",
            "",
            R.drawable.nightbooks
        ),
        Movies(
            "coco",
            "",
            R.drawable.coco
        ),
        Movies(
            "aladin",
            "",
            R.drawable.aladin
        ),
        Movies(
            "matrixt",
            "",
            R.drawable.matrix
        ),
        Movies(
            "onward",
            "",
            R.drawable.onward
        ),
        Movies(
            "house of horrors",
            "",
            R.drawable.house_of_horrors
        )
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {

        Listings(title = "New Release", movies = movies)
    }
}

@Preview(showBackground = true)
@Composable
fun NewReleaseSectionPreview() {
    NewReleaseSection()
}
package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components.CategorySection

@Composable
fun SearchPage(modifier: Modifier = Modifier) {
    SearchBody()
}

@Composable
fun SearchBody() {
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
            textValue = "",
            label = "Recherche...",
            keyboardType = KeyboardType.Text,
            shape = RoundedCornerShape(50.dp),
            content = {
                Icon(Icons.Rounded.Search, contentDescription = "search icon")
            }) {

        }


//        CategorySection()


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(12) {
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Card {
                        Image(
                            painter = painterResource(id = R.drawable.onward),
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
    SearchBody()
}
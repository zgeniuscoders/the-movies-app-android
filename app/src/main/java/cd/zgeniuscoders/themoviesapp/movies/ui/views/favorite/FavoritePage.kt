package cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent

@Composable
fun FavoritePage(modifier: Modifier = Modifier) {
    FavoriteBody()
}

@Composable
fun FavoriteBody() {
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

        items(12) {
            Row(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(220.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onward),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Column {
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        "OnWard", style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        "Un message de verification vous a été envoyer Par l’addresse email zgeniusco ders@gmail.com",
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Release Date")
                    Text(
                        "18 December 2024",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun FavoritePreview(modifier: Modifier = Modifier) {
    FavoriteBody()
}
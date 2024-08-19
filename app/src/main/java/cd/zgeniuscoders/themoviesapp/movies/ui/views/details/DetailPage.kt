package cd.zgeniuscoders.themoviesapp.movies.ui.views.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import cd.zgeniuscoders.themoviesapp.common.ui.theme.secondaryDark

@Composable
fun DetailPage(navHostController: NavHostController) {
    DetailBody(navHostController)
}

@Composable
fun DetailBody(navHostController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Column {

                Box {
                    Image(
                        painter = painterResource(id = R.drawable.house_of_horrors),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        IconButton(
                            onClick = {
                                navHostController.popBackStack()
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = green,
                                contentColor = secondaryDark
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBackIosNew,
                                contentDescription = null
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))


                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        "House of Horrors", style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "128 minutes",
                            color = Color.Gray,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            "7k Downloads",
                            color = Color.Gray,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                Divider()

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            "Release date",
                        )
                        Text(
                            text = "December 12 2024",
                            color = Color.Gray,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Column {
                        Text("Genre")
                        Text(
                            text = "Action",
                            color = green,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }

                Divider()

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        "Sypnosis"
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "WordPress est l’un des systèmes de gestion de contenu \n" +
                                "(CMS) les plus populaires et les plus puissants au \n" +
                                "monde. Lancé en 2003, WordPress \n"
                    )
                }

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DetailPreview(modifier: Modifier = Modifier) {
    DetailBody(navHostController = rememberNavController())
}
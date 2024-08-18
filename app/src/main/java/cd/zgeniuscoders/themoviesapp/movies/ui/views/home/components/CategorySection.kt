package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green

@Composable
fun CategorySection(modifier: Modifier = Modifier) {
    val currentItem = remember {
        mutableIntStateOf(0)
    }

    val categories = listOf(
        "All",
        "Actions",
        "Dramatics",
        "Horrors",
        "Science Fiction",
        "Romantics"
    )
    
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(categories.size) {
            Text(
                text = categories[it],
                style = MaterialTheme.typography.titleMedium,
                color = if (currentItem.value == it) green else Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable {
                        currentItem.value = it
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategorySectionPreview(modifier: Modifier = Modifier) {
    CategorySection()
}
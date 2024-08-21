package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.HomeEvent

@Composable
fun CategorySection(categories: List<Category>, onEvent: (event: HomeEvent) -> Unit) {
    val currentItem = remember {
        mutableStateOf("all")
    }


    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        item {
            Text(
                text = "all",
                style = MaterialTheme.typography.titleMedium,
                color = if (currentItem.value == "all") green else Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable {
                        currentItem.value = "all"
                        onEvent(
                            HomeEvent.OnCategoryChange("all")
                        )
                    }
            )
        }
        items(categories.size) {
            val categoryName = categories[it].name
            Text(
                text = categoryName,
                style = MaterialTheme.typography.titleMedium,
                color = if (currentItem.value == categoryName) green else Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable {
                        currentItem.value = categoryName
                        onEvent(
                            HomeEvent.OnCategoryChange(categoryName)
                        )
                    }
            )
        }
    }
}

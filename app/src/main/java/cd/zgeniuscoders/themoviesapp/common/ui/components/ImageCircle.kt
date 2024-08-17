package cd.zgeniuscoders.themoviesapp.common.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.R

@Composable
fun ImageCircle(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.coco),
        contentDescription = "",
        modifier = modifier.size(50.dp)
    )
}
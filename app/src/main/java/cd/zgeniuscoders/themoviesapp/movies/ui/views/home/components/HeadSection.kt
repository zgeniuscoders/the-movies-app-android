package cd.zgeniuscoders.themoviesapp.movies.ui.views.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green


@Composable
fun HeadSection() {

    val pagerState = rememberPagerState(pageCount = {
        4
    })


    val images = listOf(
        R.drawable.nightbooks,
        R.drawable.coco,
        R.drawable.matrix,
        R.drawable.harry_potter
    )


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (horinzotalPager, cardIndicator) = createRefs()

        HorizontalPager(
            modifier = Modifier
                .constrainAs(horinzotalPager) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            state = pagerState,
        ) { page ->


            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(cardIndicator) {
                    bottom.linkTo(parent.bottom)
                }
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = green,
                            contentColor = Color.White
                        )
                    ) {
                        Icon(Icons.Rounded.PlayArrow, contentDescription = "play icon")
                    }
                    Text(
                        "Watch it first",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) green else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(10.dp)
                        )
                    }
                }
            }




        }

    }

}

@Preview(showBackground = true)
@Composable
fun HeadPreview(modifier: Modifier = Modifier) {
    HeadSection()
}
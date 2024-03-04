package com.example.movieApp.presantation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieApp.data.utils.Constants.POSTER_PATH_URL


@Composable
fun MainScreenItem(
    model: String,
    modifier: Modifier = Modifier,
    image: Painter,

    ) {
    Box(
        modifier = Modifier
            .height(210.dp)
            .width(140.dp)
            .clip(shape = RoundedCornerShape(size = 14.dp)),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = modifier
                .clip(shape = RoundedCornerShape(size = 14.dp)),
            model = POSTER_PATH_URL + model,
            contentDescription = null,
            placeholder = image,
        )
    }
}

@Composable
fun MainScreenItemSacond(
    imageUrl: String,
    modifier: Modifier = Modifier,
    image: Painter,
    movieID: Int,
    onNavigaiteToInfo: (Int) -> Unit

) {
    Box(
        modifier = Modifier
            .height(145.dp)
            .width(100.dp)
            .clip(shape = RoundedCornerShape(size = 14.dp))
            .clickable {
                onNavigaiteToInfo(movieID)
            },
        contentAlignment = Alignment.Center

    ) {
        AsyncImage(
            modifier = modifier
                .clip(shape = RoundedCornerShape(size = 14.dp)),
            model = POSTER_PATH_URL + imageUrl,
            contentDescription = null,
            placeholder = image,
            contentScale = ContentScale.Crop
        )
    }
}


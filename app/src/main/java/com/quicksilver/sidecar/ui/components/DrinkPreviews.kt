package com.quicksilver.sidecar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.quicksilver.sidecar.ui.theme.SidecarTheme

@Composable
fun DrinkChipCarousel(urls: List<String>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.wrapContentSize(),
        horizontalArrangement = spacedBy(8.dp)
    ) {
        items(urls) { url -> DrinkChip(url = url) }
    }
}

@Composable
fun DrinkChip(url: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(36.dp)
            .height(64.dp)
            .clip(RoundedCornerShape(size = 8.dp))
    ) {
        Image(
            modifier = Modifier.background(color = MaterialTheme.colors.primary),
            painter = rememberImagePainter(
                data = url,
                builder = { crossfade(true) }
            ),
            contentDescription = "",
            contentScale = Crop
        )
        Icon(
            modifier = Modifier
                .size(10.dp)
                .align(Alignment.BottomStart)
                .padding(start = 4.dp, bottom = 4.dp),
            imageVector = Icons.Filled.Star,
            tint = Color.White,
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun DrinkChipPreview() {
    SidecarTheme {
        DrinkChip(url = PreviewUrls[0])
    }
}

@Preview
@Composable
fun DrinkChipCarouselPreview() {
    SidecarTheme {
        DrinkChipCarousel(urls = PreviewUrls)
    }
}

val PreviewUrls = listOf(
    "https://images.squarespace-cdn.com/content/v1/5c757fc5e4afe93ee42b83d3/1591747461167-4WNIYTG70OAPWX32STDY/melissa-walker-horn-gtDYwUIr9Vg-unsplash.jpg?format=2500w",
    "https://images.squarespace-cdn.com/content/v1/599b9c479f8dce44741fd8fd/1625248730184-IL33OU3YCE71QSTB123A/sam-hojati-pb7oJwtNVU4-unsplash.jpg",
    "https://s3-alpha-sig.figma.com/img/3e00/90cb/48acd20d8b04559da9ed3635cef189cb?Expires=1630281600&Signature=aIcwcn5MOCtCv9FfPF5lku~AxgQEaJOEmqzAoXRF3ZkjLLGKYvKbYIGUY4Q-m55HMBldhNYYNoLxOakIqGrgzUTIc54-85Cip720Fu0rOM~A3DC3-E8NYLRojfw~zvYPVsJh5kEpFpu3nRwhXCw8UWU6H8GkYwJC43pEGcjCR1ulXG8Ou4zoeU6yErjqxSW3QYisDPNDJPKB9HYIOg90wfW6ZaHNBeXa7K6WLmazBZVLuTM8yKUGTUBfQBxEXTR4J~4qTDGlreLsjqsj5R~uxs3owy-Rxvq6zW7NbA6rvYp5SsNX8aIbXKeFRmk7-7dRa8u6QKhuBOxYKCKgEhSw2w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
    "https://images.unsplash.com/photo-1523677011781-c91d1bbe2f9e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwcm9maWxlLXBhZ2V8NXx8fGVufDB8fHx8&w=1000&q=80",
    "https://images.squarespace-cdn.com/content/v1/600aeae9d2a8133c359aafe7/1625841043384-DOANLLUXYONBXNFH3NZK/jenny-pace-K5IUb0kBZZ8-unsplash.jpg",
    "https://images.unsplash.com/photo-1527661591475-527312dd65f5?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max"
)

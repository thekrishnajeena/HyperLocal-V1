package com.krishnajeena.hyperlocal_v1.widget.banner

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun BannerWidget(instanceId: String) {
    val banners = remember(instanceId) {
        BannerDataGenerator.getBanners(instanceId)
    }

    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(banners) { banner ->
            BannerItem(banner = banner)
        }
    }
}



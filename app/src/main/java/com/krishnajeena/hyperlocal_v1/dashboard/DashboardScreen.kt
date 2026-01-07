package com.krishnajeena.hyperlocal_v1.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.krishnajeena.hyperlocal_v1.widget.models.WidgetType
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.krishnajeena.hyperlocal_v1.widget.banner.BannerWidget
import com.krishnajeena.hyperlocal_v1.widget.list.ListWidget
import com.krishnajeena.hyperlocal_v1.widget.models.WidgetMeta

@Composable
fun DashboardScreen(
    innerPaddingValues: PaddingValues,
    viewModel: DashboardViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
    when {
        uiState.isLoading -> CircularProgressIndicator()
        uiState.error != null -> Text(uiState.error!!)
        else -> DashboardContent(uiState.widgets)
    }
}
}

@Composable
fun DashboardContent(
    widgets: List<WidgetMeta>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(
            items = widgets,
            key = { it.instanceId }
        ) { widget ->
            when (widget.type) {
                WidgetType.BANNER ->
                    BannerWidget(widget.instanceId)
                WidgetType.LIST ->
                    ListWidget(widget.instanceId)
            }
        }
    }
}


package com.krishnajeena.hyperlocal_v1.dashboard

import com.krishnajeena.hyperlocal_v1.widget.models.WidgetMeta

data class DashboardUiState(
    val isLoading: Boolean = false,
    val widgets: List<WidgetMeta> = emptyList(),
    val error: String? = null
)

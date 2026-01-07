package com.krishnajeena.hyperlocal_v1.widget.list

data class ListUiState(
    val isLoading: Boolean = false,
    val data: List<ListWidgetConfig> = emptyList(),
    val error: String? = null
)

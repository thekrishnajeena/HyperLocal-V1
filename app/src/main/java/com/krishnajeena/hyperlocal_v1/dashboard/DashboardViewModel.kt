package com.krishnajeena.hyperlocal_v1.dashboard

import androidx.lifecycle.ViewModel
import com.krishnajeena.hyperlocal_v1.data.DashboardDataSource
import com.krishnajeena.hyperlocal_v1.widget.models.WidgetMeta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        DashboardUiState(isLoading = true)
    )
    val uiState = _uiState.asStateFlow()

    init {
        loadDashboard()
    }

    private fun loadDashboard() {
        _uiState.value = DashboardUiState(
            widgets = DashboardDataSource.getWidgets()
        )
    }

}

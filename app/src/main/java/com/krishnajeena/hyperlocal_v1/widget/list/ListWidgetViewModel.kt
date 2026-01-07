package com.krishnajeena.hyperlocal_v1.widget.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListWidgetViewModel(
    private val instanceId: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            delay(1000)
            try {
                val data = ListDataGenerator.getListData(instanceId)
                _uiState.value = ListUiState(data = data)
            } catch (e: Exception) {
                _uiState.value = ListUiState(error = "Something went wrong")
            }
        }
    }
}

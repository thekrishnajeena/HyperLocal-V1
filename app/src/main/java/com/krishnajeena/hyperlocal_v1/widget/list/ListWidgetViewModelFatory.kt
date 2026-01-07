package com.krishnajeena.hyperlocal_v1.widget.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListWidgetViewModelFactory(
    private val instanceId: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListWidgetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListWidgetViewModel(instanceId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

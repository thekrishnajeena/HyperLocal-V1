package com.krishnajeena.hyperlocal_v1.data

import com.krishnajeena.hyperlocal_v1.widget.models.WidgetMeta
import com.krishnajeena.hyperlocal_v1.widget.models.WidgetType

object DashboardDataSource {
    fun getWidgets(): List<WidgetMeta> = listOf(
        WidgetMeta(WidgetType.BANNER, "pokemon"),
        WidgetMeta(WidgetType.BANNER, "cars"),
        WidgetMeta(WidgetType.BANNER, "bikes"),
        WidgetMeta(WidgetType.LIST, "movies"),
        WidgetMeta(WidgetType.LIST, "shows")
    )
}

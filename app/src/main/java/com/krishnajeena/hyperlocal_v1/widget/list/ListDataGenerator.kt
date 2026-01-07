package com.krishnajeena.hyperlocal_v1.widget.list

object ListDataGenerator {

    fun getListData(instanceId: String): List<ListWidgetConfig> {
        return when (instanceId) {
            "movies" -> listOf(
                ListWidgetConfig("Inception", "2010"),
                ListWidgetConfig("Interstellar", "2014")
            )
            "shows" -> listOf(
                ListWidgetConfig("Breaking Bad", "Drama"),
                ListWidgetConfig("Dark", "Sci-Fi")
            )
            else -> listOf(
                ListWidgetConfig("Default", "Item")
            )
        }
    }
}

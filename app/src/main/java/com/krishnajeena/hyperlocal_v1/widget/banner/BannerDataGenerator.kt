package com.krishnajeena.hyperlocal_v1.widget.banner

object BannerDataGenerator {
    fun getBanners(instanceId: String): List<BannerConfig> {
        return when (instanceId) {
            "pokemon" -> listOf(
                BannerConfig("Pikachu", "Electric type"),
                BannerConfig("Charizard", "Fire type")
            )
            "cars" -> listOf(
                BannerConfig("Tesla", "Electric"),
                BannerConfig("BMW", "Luxury")
            )
            else -> listOf(
                BannerConfig("Default", "Subtitle")
            )
        }
    }
}

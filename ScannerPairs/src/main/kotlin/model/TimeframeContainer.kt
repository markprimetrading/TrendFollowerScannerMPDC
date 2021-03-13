package model

data class TimeframeContainer(
    val container: ResponseContainer,
    val timeframe: Timeframe
)

enum class Timeframe { MIN_1, MIN_5, MIN_15, MIN_30, MIN_60 }

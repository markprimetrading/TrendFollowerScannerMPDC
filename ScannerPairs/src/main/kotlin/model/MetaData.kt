package model

data class MetaData(
    val information: String,
    val fromSymbol: String,
    val toSymbol: String,
    val lastRefreshed: String,
    val interval: String,
    val outputSize: String,
    val timeZone: String
)
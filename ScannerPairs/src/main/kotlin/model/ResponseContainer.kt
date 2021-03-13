package model

import model.IntradayItem
import model.MetaData

data class ResponseContainer(
    val metaData: MetaData,
    val mapOfItems: Map<String, IntradayItem>
)

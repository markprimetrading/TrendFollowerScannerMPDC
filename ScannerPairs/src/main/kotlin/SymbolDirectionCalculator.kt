import model.*

class SymbolDirectionCalculator(
    private val symbolTimeframeDirectionCalculator: SymbolTimeframeDirectionCalculator
) {
    @Throws(NotEnoughDataException::class)
    fun getDirection(timeframeContainerList: List<TimeframeContainer>): TradeAction? {

        val timeframeDirections: MutableList<Direction> = ArrayList()

        for (timeframeContainer in timeframeContainerList) {

            val timeframeDirection = when (timeframeContainer.timeframe) {
                Timeframe.MIN_1 -> symbolTimeframeDirectionCalculator.calculateDirection(
                    9,
                    18,
                    timeframeContainer.container
                )
                Timeframe.MIN_5 -> symbolTimeframeDirectionCalculator.calculateDirection(
                    9,
                    18,
                    timeframeContainer.container
                )
                Timeframe.MIN_15 -> symbolTimeframeDirectionCalculator.calculateDirection(
                    9,
                    18,
                    timeframeContainer.container
                )
                Timeframe.MIN_30 -> symbolTimeframeDirectionCalculator.calculateDirection(
                    21,
                    50,
                    timeframeContainer.container
                )
                Timeframe.MIN_60 -> symbolTimeframeDirectionCalculator.calculateDirection(
                    10,
                    100,
                    timeframeContainer.container
                )
            }

            timeframeDirections.add(timeframeDirection)
        }

        val isAllUp = timeframeDirections.all { it == Direction.UP }
        val isAllDown = timeframeDirections.all { it == Direction.DOWN }

        return when {
            isAllUp -> TradeAction.BUY
            isAllDown -> TradeAction.SELL
            else -> null
        }
    }
}


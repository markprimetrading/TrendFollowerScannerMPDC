import model.Direction
import model.IntradayItem
import model.NotEnoughDataException
import model.ResponseContainer
import java.math.BigDecimal

class SymbolTimeframeDirectionCalculator {

    @Throws(NotEnoughDataException::class)
    fun calculateDirection(fastPeriod: Int, slowPeriod: Int, container: ResponseContainer): Direction {

        val items: List<IntradayItem> = container.mapOfItems.values.toList()

        var sumSlowMA = BigDecimal(0.0)

        for (index in 0 until slowPeriod) {
            sumSlowMA += items.getOrNull(index)?.close?.toBigDecimal()
                ?: throw NotEnoughDataException("We need more data!")
        }

        val slowMa = sumSlowMA / slowPeriod.toBigDecimal()

        var sumFastMA = BigDecimal(0.0)

        for (index in 0 until fastPeriod) {
            sumFastMA += items.getOrNull(index)?.close?.toBigDecimal()
                ?: throw NotEnoughDataException("We need more data!")
        }

        val fastMa = sumFastMA / fastPeriod.toBigDecimal()

        return if (fastMa >= slowMa) Direction.UP
        else Direction.DOWN

    }

}



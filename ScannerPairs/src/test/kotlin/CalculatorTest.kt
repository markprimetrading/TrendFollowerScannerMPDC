import junit.framework.Assert.assertEquals
import model.*
import org.junit.Test

class CalculatorTest {

    @Test
    fun calculateDirectionUp() {

        val directionCalculator = SymbolTimeframeDirectionCalculator()
        val myMetadata: MetaData = MetaData("test", "USD", "EUR", "01.01.2020 03:00:00", "5min", "Compact", "GMT")

        val myIntradayItem1: IntradayItem = IntradayItem("1.12323", "1.12343", "1.12313", "1.12500")
        val myIntradayItem2: IntradayItem = IntradayItem("1.12333", "1.12323", "1.12313", "1.12400")
        val myIntradayItem3: IntradayItem = IntradayItem("1.12363", "1.12353", "1.12343", "1.12300")
        val myIntradayItem4: IntradayItem = IntradayItem("1.12343", "1.12353", "1.12313", "1.12200")
        val myIntradayItem5: IntradayItem = IntradayItem("1.12373", "1.12343", "1.12333", "1.12100")

        val myMap = LinkedHashMap<String, IntradayItem>()

        myMap["1"] = myIntradayItem1
        myMap["2"] = myIntradayItem2
        myMap["3"] = myIntradayItem3
        myMap["4"] = myIntradayItem4
        myMap["5"] = myIntradayItem5

        val myTestContainer: ResponseContainer = ResponseContainer(myMetadata, myMap)
        val result = directionCalculator.calculateDirection(2, 4, myTestContainer)

        assertEquals(Direction.UP, result)
    }


    @Test
    fun calculateDirectionDown() {

        val directionCalculator = SymbolTimeframeDirectionCalculator()
        val myMetadata: MetaData = MetaData("test", "USD", "EUR", "01.01.2020 03:00:00", "5min", "Compact", "GMT")

        val myIntradayItem1: IntradayItem = IntradayItem("1.10492", "1.12343", "1.12313", "1.12100")
        val myIntradayItem2: IntradayItem = IntradayItem("1.12333", "1.12323", "1.12313", "1.12200")
        val myIntradayItem3: IntradayItem = IntradayItem("1.12363", "1.12353", "1.12343", "1.12300")
        val myIntradayItem4: IntradayItem = IntradayItem("1.12343", "1.12353", "1.12313", "1.12400")
        val myIntradayItem5: IntradayItem = IntradayItem("1.12373", "1.12343", "1.12333", "1.12500")

        val myMap = LinkedHashMap<String, IntradayItem>()

        myMap["1"] = myIntradayItem1
        myMap["2"] = myIntradayItem2
        myMap["3"] = myIntradayItem3
        myMap["4"] = myIntradayItem4
        myMap["5"] = myIntradayItem5

        val myTestContainer: ResponseContainer = ResponseContainer(myMetadata, myMap)
        val result = directionCalculator.calculateDirection(2, 4, myTestContainer)

        assertEquals(Direction.DOWN, result)
    }

    @Test(expected = NotEnoughDataException::class)
    fun calculateDirectionNotEnoughData() {

        val directionCalculator = SymbolTimeframeDirectionCalculator()
        val myMetadata: MetaData = MetaData("test", "USD", "EUR", "01.01.2020 03:00:00", "5min", "Compact", "GMT")

        val myIntradayItem1: IntradayItem = IntradayItem("1.12323", "1.12343", "1.12313", "1.12328")
        val myIntradayItem2: IntradayItem = IntradayItem("1.12333", "1.12323", "1.12313", "1.12308")
        val myIntradayItem3: IntradayItem = IntradayItem("1.12363", "1.12353", "1.12343", "1.12368")
        val myIntradayItem4: IntradayItem = IntradayItem("1.12343", "1.12353", "1.12313", "1.12358")
        val myIntradayItem5: IntradayItem = IntradayItem("1.12373", "1.12343", "1.12333", "1.12388")

        val myMap = LinkedHashMap<String, IntradayItem>()

        myMap["1"] = myIntradayItem1
        myMap["2"] = myIntradayItem2
        myMap["3"] = myIntradayItem3
        myMap["4"] = myIntradayItem4
        myMap["5"] = myIntradayItem5

        val myTestContainer: ResponseContainer = ResponseContainer(myMetadata, myMap)
        val result = directionCalculator.calculateDirection(12, 24, myTestContainer)

    }



}


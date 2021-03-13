import model.*
import org.junit.Test
import java.awt.Container

class SymbolTimeframeDirectionCalculatorTest {

    @Test
    fun getAllDirectionsUp(){

        //given
        val symbolDirectionCalculator = SymbolDirectionCalculator(SymbolTimeframeDirectionCalculator())
        val list = listOf<TimeframeContainer>()


        //when
        mySymbolDirectionCalculator.getDirection()

        //then

    }

    @Test
    fun getAllDirectionsDown(){

    }

    @Test
    fun getAllDirectionsMixed(){

    }


    private fun createTimeframeContainer(timeframe: Timeframe): TimeframeContainer{
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

        return TimeframeContainer(myTestContainer,timeframe)
    }


}
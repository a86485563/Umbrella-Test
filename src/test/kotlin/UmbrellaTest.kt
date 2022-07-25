import org.junit.Assert
import org.junit.jupiter.api.Test

class UmbrellaTest {

    //SUT : Umbrella.total
    //stub : StubWeather
    //stub
    class StubWeather : IWeather {
        override fun isSunny() : Boolean {
            return true
        }
    }

    //expected : 90
    //stub : IWeather
    @Test
    fun totalPrice() {
        val weather = StubWeather()
        //init price 100
        val umbrella = Umbrella(100, Weather())
        val expected = 90
        val actual = umbrella.totalPrice(1,weather)

        Assert.assertEquals(expected,actual)
    }




    //expected : 90
    //stub : IWeather
    @Test
    fun totalPriceConstructor() {
        val weather : IWeather = StubWeather()
        val umbrella = Umbrella(weather = weather)
        val expected = 90
        val cost = umbrella.totalPriceConstructor(1)
        Assert.assertEquals(expected,cost)
    }
}
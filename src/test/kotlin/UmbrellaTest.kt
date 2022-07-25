import org.junit.Assert
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class UmbrellaTest {

    //SUT : Umbrella.total
    //stub : StubWeather
    //stub
    class StubWeather : IWeather {
        override fun isSunny() : Boolean {
            return true
        }
    }
    class MockEmailUtil :IEmailUtil{
        // receiveEmail 用來記錄由sendCustomer傳進來的Email
        //用來驗證是否有正確的與相依互動
        public var receiveMail : String? = null
        public var totalPrice : Int? = null
        public var quantity : Int? = null
        override fun sendEmail(mail: String?, price: Int, quantity: Int) {
            this.receiveMail = mail
            this.totalPrice = price
            this.quantity = quantity
        }
    }
    //expected : 90
    //stub : IWeather
    @Test
    fun totalPrice() {
        val weather = StubWeather()
        //init price 100
        val umbrella = Umbrella(100, Weather(),)
        val expected = 90
        val actual = umbrella.calTotalPrice(1,weather)

        Assert.assertEquals(expected,actual)
    }

    //expected : 90
    //stub : IWeather
    @Test
    fun given_SunnyDay_When_BuyUmbrella_Expect_Discount() {
        val weather = mock(IWeather::class.java)
        `when`(weather.isSunny()).thenReturn(true)
        val umbrella = Umbrella(100, weather)
        val expected = 90
        val cost = umbrella.calTotalPrice(1)
        Assert.assertEquals(expected,cost)

    }

    //expected : 90
    //SUT : umbrella.insertOrder
    //stub : IWeather
    //mock : emailUtil : 驗證 insertOrder 有使用到emailUtil 的 sendMethod()
    @Test
    fun given_Profile_When_BuyUmbrella_Expect_SendEmailToUser() {
        //stub
        val weather = mock(IWeather::class.java)
        `when`(weather.isSunny()).thenReturn(true)
        //mock
        val mockEmailUtil = mock(IEmailUtil::class.java)

        val oriPrice = 100
        val umbrella = Umbrella(oriPrice,weather,mockEmailUtil)
        val quantity = 1
        val receiveEmail = "abctest@gmail.com"
        val totalPrice = 90

        umbrella.insertOrder(1,receiveEmail,totalPrice)
//        verify(mockEmailUtil).sendEmail(receiveEmail,totalPrice,quantity)
        verify(mockEmailUtil, times(1)).sendEmail(receiveEmail,totalPrice,quantity)
    }

}
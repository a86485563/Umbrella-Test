fun main(args: Array<String>) {
    val weather : IWeather = Weather()
    val emailUtil = EmailUtil()
    val umbrella =  Umbrella(100, weather,emailUtil)
    val totalPrice = umbrella.calTotalPrice(1)
    val receiveEmail = "abcTest@gmail.com"
    umbrella.insertOrder(1,receiveEmail,totalPrice)
//    println("price : "+ umberlla.totalPrice(1,weather))
}
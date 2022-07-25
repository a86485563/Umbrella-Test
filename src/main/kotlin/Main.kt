fun main(args: Array<String>) {
    val weather : IWeather = Weather()
    val emailUtil = EmailUtil()
    val umberlla =  Umbrella(100, Weather(),emailUtil)
    umberlla.insertOrder(1)
//    println("price : "+ umberlla.totalPrice(1,weather))
}
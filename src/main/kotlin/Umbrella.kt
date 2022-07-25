class Umbrella(private val price: Int = 100, private val weather: IWeather) {

    fun totalPrice(quantity: Int, weather: IWeather) : Int {
        //計算金額
        var total = price * quantity
        val isSunny = weather.isSunny()
        //看天氣給折扣
        if(isSunny){
            total = (total * 0.9).toInt()
        }
        return total
    }


    fun totalPriceConstructor(quantity: Int) : Int {
        //計算金額
        var total = price * quantity
        val isSunny = weather.isSunny()
        //看天氣給折扣
        if(isSunny){
            total = (total * 0.9).toInt()
        }
        return total
    }

}


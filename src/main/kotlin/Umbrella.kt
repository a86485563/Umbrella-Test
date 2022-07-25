class Umbrella {
    private var price : Int? = null
    private var weather : IWeather? =null
    private var emailUtil : IEmailUtil? = null
    constructor(_price: Int = 100,  _weather: IWeather){
        price = _price
        weather = _weather
    }
    constructor(_price: Int = 100,  _weather: IWeather,_emailUtil: IEmailUtil){
        price = _price
        weather = _weather
        emailUtil = _emailUtil
    }

    fun calTotalPrice(quantity: Int, weather: IWeather) : Int {
        //計算金額
        var total = price!! * quantity
        val isSunny = weather.isSunny()
        //看天氣給折扣
        if(isSunny){
            total = (total * 0.9).toInt()
        }
        return total
    }


    fun calTotalPrice(quantity: Int) : Int {
        //計算金額
        var total = price!! * quantity
        val isSunny = weather?.isSunny()
        //看天氣給折扣
        if(isSunny == true){
            total = (total * 0.9).toInt()
        }
        return total
    }

    //當今天使用者完成訂單後，寄信給使用者。使用emailUtil。採用construct inject 方式。
    //目標：計算價格、寄信提醒使用者訂單完成。

    fun insertOrder(quantity: Int,receiveEmail : String,totalPrice : Int){
        emailUtil?.sendEmail(receiveEmail,totalPrice,quantity)
    }


}



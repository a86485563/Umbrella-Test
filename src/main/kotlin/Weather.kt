interface IWeather {
    fun isSunny() : Boolean
}

class Weather : IWeather {
    override fun isSunny() : Boolean {
        return true
    }
}

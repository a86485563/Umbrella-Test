interface IEmailUtil {
    fun sendEmail(mail: String?, price: Int, quantity : Int)
}

class EmailUtil : IEmailUtil {
    override fun sendEmail(mail: String?, price: Int, quantity : Int) {
        println("send to $mail, quantity is $quantity and total price is $price")
    }
}

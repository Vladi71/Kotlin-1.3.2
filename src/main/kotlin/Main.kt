package ru.netology


fun main() {
    println(transfer(0, 900000, "mastercard and Maestro"))

}

fun transfer(total: Int, amount: Int, transferMethod: String): Int {

    return when (transferMethod) {
        "mastercard and Maestro" -> mastercardAndMaestro(total, amount)
        "visa and Mir" -> visaAndMir(total, amount)
        else -> vkPay(total, amount)
    }
}

fun mastercardAndMaestro(total: Int, amount: Int): Int {
    val masterCommission = 0.0060
    val commission: Int = (amount * masterCommission + 2000).toInt()
    val noCommission = 0

    return  when {
        total + amount <= 75_000_00  -> noCommission
        else -> commission
    }

}

fun visaAndMir(total: Int, amount: Int): Int {
    val minCommission = 3500
    val percentCommission = 0.0075
    val commission: Int = (amount * percentCommission).toInt()
    return when {
        commission < 3500 -> minCommission
        else -> commission
    }
}

fun vkPay(total: Int, amount: Int): Int {
    return 0
}

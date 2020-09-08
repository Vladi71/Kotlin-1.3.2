package ru.netology


fun main() {
    println(transfer(0, 3000, "visa and Mir"))

}

fun transfer(total: Int, amount: Int, transferMethod: String): String {

    return when (transferMethod) {
        "mastercard and Maestro" -> mastercardAndMaestro(total, amount)
        "visa and Mir" -> visaAndMir(total, amount)
        "vkPay" -> vkPay(total, amount)
        else -> "Данный счет не существует!"
    }
}

fun mastercardAndMaestro(total: Int, amount: Int): String {
    val masterCommission = 0.0060
    val commission: Int = (amount * masterCommission + 2000).toInt()
    return when {
        total + amount <= 7_500_000 || total + amount >= 300_00 -> "Перевод выполнен! Комиссия составила 0 коп."
        else -> "Перевод выполнен! Комиссия составила $commission коп."
    }
}

fun visaAndMir(total: Int, amount: Int): String {
    val minCommission = 3500
    val percentCommission = 0.0075
    val commission: Int = (amount * percentCommission).toInt()
    return when {
        commission < 3500 -> "Перевод выполнен! Комиссия составила $minCommission коп."
        else -> "Перевод выполнен! Комиссия составила $commission коп."
    }
}

fun vkPay(total: Int, amount: Int): String {
    return when {
        total > 40_000_00 -> "Превышен лимит переводов в месяц!"
        amount > 15_000_00 -> "Превышена максимальная сумма перевода!"
        else -> "Перевод выполнен! Комиссия составила 0 коп."
    }
}

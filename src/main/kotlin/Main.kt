package ru.netology


const val amount = 80_000_00

fun main() {
    val transferMethod = "mastercard and Maestro"
    when (transferMethod) {
        "mastercard and Maestro" -> mastercardAndMaestro()
        "visa and Mir" -> visaAndMir()
        "vkPay" -> vkPay()
    }
}

fun mastercardAndMaestro() {
    val total = 20_000_00
    val totalDay = 0
    val masterCommission = 0.0060
    val commission: Int = (amount * masterCommission + 2000).toInt()
    when {
        totalDay + amount > 150_000_00 -> println("Превышен лимит перевода в сутки!")
        total + amount > 600_000_00 -> println("Превышен лимит перевода в текущем месяце!")
        total + amount <= 7_500_000 -> println("Перевод выполнен! Комиссия составила 0 коп.")
        else -> println("Перевод выполнен! Комиссия составила $commission коп.")
    }
}

fun visaAndMir() {
    val total = 15_000_00
    val totalDay = 0
    val minCommission = 3500
    val percentCommission = 0.0075
    val commission: Int = (amount * percentCommission).toInt()
    val result = when {
        total + amount > 600_000_00 -> println("Превышен лимит перевода в текущем месяце!")
        totalDay + amount > 150_000_00 -> println("Превышен лимит перевода в сутки!")
        commission < minCommission -> minCommission
        else -> commission
    }
    println("Перевод выполнен! Комиссия составила $result коп.")
}

fun vkPay() {
    val total = 0
    when {
        total > 40_000_00 -> println("Превышен лимит переводов в месяц!")
        amount > 15_000_00 -> println("Превышена максимальная сумма перевода!")
        else -> println("Перевод выполнен! Комиссия составила 0 коп.")
    }

}

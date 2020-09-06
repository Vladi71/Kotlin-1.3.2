package ru.netology




fun main() {
    transfer(0,120000)

}
fun transfer(total: Int, amount: Int){
    val transferMethod = "vkPay"
    when (transferMethod) {
        "mastercard and Maestro" -> mastercardAndMaestro(total, amount)
        "visa and Mir" -> visaAndMir(total, amount)
        "vkPay" -> vkPay(total, amount)
    }
}

fun mastercardAndMaestro(total: Int, amount: Int) {
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

fun visaAndMir(total: Int, amount: Int) {
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

fun vkPay(total: Int, amount: Int) {
    when {
        total > 40_000_00 -> println("Превышен лимит переводов в месяц!")
        amount > 15_000_00 -> println("Превышена максимальная сумма перевода!")
        else -> println("Перевод выполнен! Комиссия составила 0 коп.")
    }

}

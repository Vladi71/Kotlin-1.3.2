package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {


    @Test
    fun mastercardAndMaestro_noCommission() {
        //arrange
        val total = 0
        val amount = 50_000_00
        //act
        val result = mastercardAndMaestro(
            total = total, amount = amount
        )
        //assert
        assertEquals(50, result)
    }

    @Test
    fun mastercardAndMaestro_Commission() {
        //arrange
        val total = 0
        val amount = 90_000_00
        //act
        val result = mastercardAndMaestro(
            total = total, amount = amount
        )
        //assert
        assertEquals(56000, result)
    }

    @Test
    fun visaAndMir_Commission() {
        //arrange
        val total = 0
        val amount = 50_000_00
        //act
        val result = visaAndMir(
            total = total, amount = amount
        )
        //assert
        assertEquals(37500, result)
    }

    @Test
    fun visaAndMir_MinCommission() {
        //arrange
        val total = 0
        val amount = 10_000
        //act
        val result = visaAndMir(
            total = total, amount = amount
        )
        //assert
        assertEquals(3500, result)
    }

    @Test
    fun vkPay_noCommission() {
        //arrange
        val total = 0
        val amount = 50_000_00
        //act
        val result = vkPay(
            total = total, amount = amount
        )
        //assert
        assertEquals(0, result)
    }
}
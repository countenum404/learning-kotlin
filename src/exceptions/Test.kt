package exceptions

import java.text.NumberFormat

fun main() {
    try {
        val a = readln().toInt()
        val b = readln().toInt()
        println(a / b)
    } catch (e: ArithmeticException) {
        println("You can't divide by zero")

    } catch (e: Throwable) {
        println("Common error: ${e}")
    }

}
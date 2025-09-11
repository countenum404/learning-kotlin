package homework.logging

fun main() {
    val log1 = LogEvent("User logged in")

    val log2 = LogEvent(404)

    val log3 = LogEvent(UserAction.CLICK_BUTTON)

    println(log1) // [2024-10-31 10:15:00]: User logged in

    println(log2) // [2024-10-31 10:20:00]: 404

    println(log3) // [2024-10-31 10:25:00]: UserAction: CLICK_BUTTON

}
package weekdays

/*
SUNDAY
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY

Воскресенье
Понедельник
Вторник
Среда
Четверг
Пятница
Суббота
* */

enum class DaysOfWeek(
    val title: String
) {
    SUNDAY(title = "Воскресенье"),
    MONDAY(title = "Понедельник"),
    TUESDAY(title = "Вторник"),
    WEDNESDAY(title = "Среда"),
    THURSDAY(title = "Четверг"),
    FRIDAY(title = "Пятница"),
    SATURDAY(title = "Суббота")
}

fun task() {
    for (weekday in DaysOfWeek.entries) {
        println(weekday)
    }
}
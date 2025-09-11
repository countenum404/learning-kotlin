package profile

fun main() {
    val p = Person(
        name = "Denis",
        lastName = "Shabashov",
        height = 186,
        weight = 90,
        age = 25
    )

    p.age = 24
    println(p.age)
}
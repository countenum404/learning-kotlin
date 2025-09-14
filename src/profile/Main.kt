package profile

fun main() {
    val person = Person(
        name = "Jhon",
        lastName = "Smith",
        height = 186,
        weight = 90,
        age = 30
    )

    val anotherPerson = Person(
        name = "Jhon",
        lastName = "Smith",
        height = 186,
        weight = 90,
        age = 30
    )

    val personThree = person.copy(name = "Nick")

    val peoples = setOf(person, anotherPerson, personThree)

    for (people in peoples) {
        println(people)
    }
}
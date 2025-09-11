package profile

class Person(
    private var name: String = "",
    var lastName: String = "",
    private var height: Int = 0,
    private var weight: Int = 0,
) {

    constructor(name: String, lastName: String, height: Int, weight: Int, age: Int) : this(name, lastName, height, weight) {
        this.age = age
    }

    val fullName: String
        get() = "$name $lastName"

    var age: Int = 0
        set(value) {
            if (field < value) {
                field = value
            }
        }
        get() {
            println("It's not polite to ask about age")
            return field
        }


    fun sayHello() {
        println("Hello")
    }

    fun run() {
        repeat(10) { println("Running") }
    }
}
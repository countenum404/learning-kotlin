package profile

fun main() {
    val p = Person()
    println("${p.name} is ${p.age} y.o.")
    p.sayHello()
    p.run()

    User(1, "Denis", "Shabashov")
}
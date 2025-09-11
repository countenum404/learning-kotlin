package corporation.employee

class Director(
    id: Int,
    name: String,
    age: Int = 0
): Employee(id, name, age, employeeType = EmployeeType.DIRECTOR), Supplier {
    fun takeCoffee(assistant: Assistant, drinkName: String) {
        println("Director $name asked ${assistant.name} to bring a coffee")
        val drinkDone = assistant.bringCoffee(drinkName)
        println("Thank you ${assistant.name} for the $drinkDone")
    }

    override fun work() {
        println("I'm drinking coffee")
    }

    override fun buyThings() {
        println("$employeeType $name is buying things")
    }
}
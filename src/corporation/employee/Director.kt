package corporation.employee

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int = 15000
): Employee(id, name, age, salary, employeeType = EmployeeType.DIRECTOR), Supplier {
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

    override fun copy(age: Int, salary: Int): Director {
        return Director(id = this.id, name = this.name, age = age, salary = salary)
    }
}
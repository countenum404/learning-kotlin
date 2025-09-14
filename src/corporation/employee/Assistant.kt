package corporation.employee

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int = 15000
): Employee(id, name, age, salary, employeeType = EmployeeType.ASSISTANT), Supplier {
    fun bringCoffee(drink: String = "Cappuccino"): String {
        println("$name saying that $drink coffee is done")
        return drink
    }

    override fun work() {
        println("Assistant $name works")
    }

    override fun buyThings() {
        println("$employeeType $name is buying things")
    }

    override fun copy(age: Int, salary: Int): Assistant {
        return Assistant(id = this.id, name = this.name, age = age, salary = salary)
    }
}
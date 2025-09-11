package corporation.employee

class Assistant(
    id: Int,
    name: String,
    age: Int = 0
): Employee(id = id, name = name, age = age, employeeType = EmployeeType.ASSISTANT), Supplier {
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
}
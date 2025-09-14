package corporation.employee

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int = 15000
): Employee(id, name, age, salary, employeeType = EmployeeType.CONSULTANT) {

    override fun work() {
        println("Consultant $name works")
    }

    override fun copy(age: Int, salary: Int): Consultant {
        return Consultant(id = this.id, name = this.name, age = age, salary = salary)
    }
}
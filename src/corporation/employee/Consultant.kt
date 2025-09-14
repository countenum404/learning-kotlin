package corporation.employee

class Consultant(
    id: Int,
    name: String,
    age: Int = 0,
    salary: Int = 15000
): Employee(id, name, age, salary, employeeType = EmployeeType.CONSULTANT) {

    override fun work() {
        println("Consultant $name works")
    }

    override fun copy(age: Int, salary: Int): Consultant {
        return Consultant(id = this.id, name = this.name, age = age, salary = salary)
    }
}
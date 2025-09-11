package corporation.employee

class Consultant(
    id: Int,
    name: String,
    age: Int = 0
): Employee(id, name = name, age = age, employeeType = EmployeeType.CONSULTANT) {

    override fun work() {
        println("Consultant $name works")
    }
}
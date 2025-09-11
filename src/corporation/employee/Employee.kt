package corporation.employee

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val employeeType: EmployeeType
) {
    var salary: Int = 15000
        set (value) {
            if (field > value) {
                println("Salary is too small")
            } else {
                field = value
            }
        }

    abstract fun work()

    open fun serialize(): String {
        return "$id%$name%$age%$salary%${employeeType}"
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Salary: $salary Position: ${employeeType.getTitle()} "
    }
}
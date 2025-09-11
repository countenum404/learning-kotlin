package corporation.employee

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val employeeType: EmployeeType
) {
    abstract fun work()

    open fun serialize(): String {
        return "$id%$name%$age%$employeeType"
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age EmployeeType: $employeeType"
    }
}
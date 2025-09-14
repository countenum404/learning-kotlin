package corporation.employee

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    val salary: Int,
    val employeeType: EmployeeType
) {

    abstract fun work()

    abstract fun copy(age: Int = this.age, salary: Int = this.salary): Employee

    open fun serialize(): String {
        return "$id%$name%$age%$salary%${employeeType}"
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Salary: $salary Position: ${employeeType.getTitle()} "
    }
}
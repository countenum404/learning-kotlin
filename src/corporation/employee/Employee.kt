package corporation.employee

abstract class Employee(
    open val id: Int,
    open val name: String,
    open val age: Int,
    open val salary: Int,
    open val employeeType: EmployeeType
) {

    abstract fun work()

    abstract fun copy(age: Int = this.age, salary: Int = this.salary): Employee

    open fun serialize(): String {
        return "$id%$name%$age%$salary%${employeeType}"
    }

    override fun toString(): String {
        return "Id: $id, Name: $name, Age: $age, Salary: $salary Position: ${employeeType.getTitle()} "
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        when {
            id != other.id -> return false
            age != other.age -> return false
            salary != other.salary -> return false
            name != other.name -> return false
            employeeType != other.employeeType -> return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + age
        result = 31 * result + salary
        result = 31 * result + name.hashCode()
        result = 31 * result + employeeType.hashCode()
        return result
    }

}
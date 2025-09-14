package corporation.repository

import corporation.employee.Accountant
import corporation.employee.Assistant
import corporation.employee.Consultant
import corporation.employee.Director
import corporation.employee.Employee
import corporation.employee.EmployeeType
import java.io.File

object EmployeesRepository {
    private val employeesFile = File("employees.txt")

    private val _employees: MutableList<Employee> = readEmployeesFromFile()
    val employees: List<Employee>
        get() = _employees.toList()

    fun save(employee: Employee) {
        _employees.add(employee)
    }

    fun fireEmployeeById(id: Int) {
        for (employee in _employees) {
            if (employee.id == id) {
                _employees.remove(employee)
                break
            }
        }
    }

    fun changeAge(id: Int, age: Int) {
        for ((index, employee) in _employees.withIndex()) {
            if (employee.id == id) {
                val newEmployee = employee.copy(age = age)
                _employees[index] = newEmployee
                break
            }
        }
    }

    fun changeSalary(id: Int, salary: Int){
        for ((index, employee) in _employees.withIndex()) {
            if (employee.id == id) {
                val newEmployee = employee.copy(salary = salary)
                _employees[index] = newEmployee
                break
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (employee in _employees) {
            content.append(employee.serialize())
            content.append("\n")
        }
        employeesFile.writeText(content.toString())
    }

    private fun readEmployeesFromFile(): MutableList<Employee> {
        val employeeList: MutableList<Employee> = mutableListOf()

        if (!employeesFile.exists()) employeesFile.createNewFile()

        val content = employeesFile.readText().trim()

        if (content.isEmpty()) return employeeList

        for (line in content.split("\n")) {
            if (line == "") continue
            val properties = line.trim().split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val employeeType = properties[4]

            val employee = when (EmployeeType.valueOf(employeeType)) {
                EmployeeType.ASSISTANT -> Assistant(id = id, name = name, age = age, salary = salary)
                EmployeeType.CONSULTANT -> Consultant(id = id, name = name, age = age, salary = salary)
                EmployeeType.DIRECTOR -> Director(id = id, name = name, age = age, salary = salary)
                EmployeeType.ACCOUNTANT -> Accountant(id = id, name = name, age = age, salary = salary)
            }
            employeeList.add(employee)
        }
        return employeeList
    }
}
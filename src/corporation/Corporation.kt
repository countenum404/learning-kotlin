package corporation

import corporation.employee.Accountant
import corporation.employee.Consultant
import homework.tasks.Employee


fun main() {
    val accountant = Accountant(id = 0, name = "Christian", 30)
    accountant.employeesRepository.save(
        employee = Consultant(
            1234567, "TEST",
            age = 400
        )
    )
    accountant.work()
}
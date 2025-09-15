package corporation

import corporation.employee.Accountant
import corporation.employee.Consultant
import corporation.repository.EmployeesRepository
import homework.tasks.Employee


fun main() {
//    val accountant = Accountant(id = 0, name = "Christian", 30)
//    accountant.work()
    val assistant = EmployeesRepository.findAssistant()
    println(assistant)
    val director = EmployeesRepository.findDirector()
    println(director)

    val directorSalary = director?.salary ?: 0
    val assistantSalary = assistant?.salary ?: 0
    println(directorSalary + assistantSalary)
}
package corporation

import corporation.employee.Accountant
import corporation.employee.Employee
import corporation.employee.Supplier


fun main() {
    val accountant = Accountant(id = 0, name = "Christian", 30)
    println(accountant)
}
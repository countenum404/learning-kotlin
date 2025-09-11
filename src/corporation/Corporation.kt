package corporation

import corporation.employee.Accountant


fun main() {
    val accountant = Accountant(id = 0, name = "Christian", 30)
    accountant.work()
}
package corporation.employee

import corporation.InputOption
import corporation.OperationCode
import corporation.cards.ProductType
import corporation.cards.GroceriesCard
import corporation.cards.HouseholdAppliancesCard
import corporation.cards.ProductCard
import corporation.cards.ShoesCard
import corporation.repository.CardsRepository
import corporation.repository.EmployeesRepository


class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int = 15000,
    var isWorking: Boolean = false
): Employee(id, name, age, salary, employeeType = EmployeeType.ACCOUNTANT), Cleaner, Supplier {

    val employeesRepository = EmployeesRepository
    val cardsRepository = CardsRepository

    override fun work() {
        isWorking = true
        while (isWorking) {
            val option = askUserForIntWithMessage(setUpMessageForAskUserInt(
                questionary = "Select operation: ",
                entries = OperationCode.entries
            ))
            when (OperationCode.entries[option]) {
                OperationCode.EXIT -> {
                    isWorking = false
                    employeesRepository.saveChanges()
                    cardsRepository.saveChanges()
                    return
                }
                OperationCode.REGISTER_NEW_ITEM -> createCard()
                OperationCode.SHOW_ALL_ITEMS -> showAllCards()
                OperationCode.REMOVE_CARD -> {
                    println("Type item name: ")
                    val name = readln()
                    cardsRepository.removeCardByName(name)
                }

                OperationCode.REGISTER_NEW_EMPLOYEE -> createEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.FIRE_EMPLOYEE -> {
                    println("Type id: ")
                    employeesRepository.fireEmployeeById(readln().toInt())
                }
                OperationCode.CHANGE_SALARY -> {
                    println("Type id: ")
                    val id: Int = readln().toInt()
                    println("Type salary: ")
                    val salary: Int = readln().toInt()
                    employeesRepository.changeSalary(id, salary)
                }
                OperationCode.CHANGE_AGE -> {
                    println("Type id: ")
                    val id: Int = readln().toInt()
                    println("Type age: ")
                    val age: Int = readln().toInt()
                    employeesRepository.changeAge(id, age)
                }
            }
        }
    }

    override fun copy(age: Int, salary: Int): Accountant {
        return Accountant(id = this.id, name = this.name, age = age, salary = salary)
    }

    override fun clean() {
        println("$employeeType $name is cleaning workspace")
    }

    private fun createEmployee() {
        val option = askUserForIntWithMessage(setUpMessageForAskUserInt(
            questionary = "Choose position: ",
            entries = EmployeeType.entries
        ))

        print("Enter id: ")
        val id = readln().toInt()
        println()

        print("Enter name: ")
        val name = readln()
        println()

        print("Enter age: ")
        val age = readln().toInt()
        println()

        print("Enter salary: ")
        val salary = readln().toInt()
        println()

        val employee: Employee = when (EmployeeType.entries[option]) {
            EmployeeType.ASSISTANT -> Assistant(id = id, name = name, age = age, salary = salary)
            EmployeeType.CONSULTANT -> Consultant(id = id, name = name, age = age, salary = salary)
            EmployeeType.DIRECTOR -> Director(id = id, name = name, age = age, salary = salary)
            EmployeeType.ACCOUNTANT -> Accountant(id = id, name = name, age = age, salary = salary)
        }
        employeesRepository.save(employee)
    }

    private fun createCard() {
        val option = askUserForIntWithMessage(setUpMessageForAskUserInt(
            questionary = "Select card type: ",
            entries = ProductType.entries
        ))
        println("Write name: ")
        val name = readln()
        println("Write brand: ")
        val brand = readln()
        println("Write price: ")
        val price = readln().toInt()

        val card: ProductCard = when(ProductType.entries[option]) {
            ProductType.GROCERIES -> {
                println("Write isPacked: ")
                val isPacked = readln().toBoolean()
                println("Write number: ")
                val number = readln().toInt()
                GroceriesCard(name = name, brand = brand, price = price, isPacked = isPacked, number = number )
            }

            ProductType.APPLIANCES -> {
                println("Write power: ")
                val power = readln().toInt()
                HouseholdAppliancesCard(name = name, brand = brand, price = price, power = power)
            }

            ProductType.SHOES -> {
                println("Write size: ")
                val size = readln().toFloat()
                ShoesCard(name = name, brand = brand, price = price, size = size)
            }
        }
        cardsRepository.save(card)
    }

    private fun showAllCards() {
        for (item in cardsRepository.cards) {
            println(item)
            println()
        }
    }

    private fun showAllEmployees() {
        for (employee in employeesRepository.employees) {
            println(employee)
        }
    }

    private fun askUserForIntWithMessage(message: String): Int {
        print(message)
        return readln().toInt()
    }

    private fun setUpMessageForAskUserInt(questionary: String, entries: List<InputOption>): String {
        var message = questionary + "\n"
        for ((index, value) in entries.withIndex()) {
            message += "$index - ${value.getTitle()}\n"
        }
        return message
    }

    override fun buyThings() {
        println("$employeeType $name is buying things")
    }

}
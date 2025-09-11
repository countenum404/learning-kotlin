package corporation.employee

import corporation.InputOption
import corporation.OperationCode
import corporation.cards.ProductType
import corporation.cards.GroceriesCard
import corporation.cards.HouseholdAppliancesCard
import corporation.cards.ProductCard
import corporation.cards.ShoesCard
import java.io.File


class Accountant(
    id: Int,
    name: String,
    age: Int,
    var isWorking: Boolean = false
): Employee(id, name, age, employeeType = EmployeeType.ACCOUNTANT), Cleaner, Supplier {
    private val productCardsFile = File("product_cards.txt")
    private val employeesFile = File("employees.txt")

    private var cards: MutableList<ProductCard> = readCardsFromFile()
    private var employees: MutableList<Employee> = readEmployeesFromFile()

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
                    return
                }
                OperationCode.REGISTER_NEW_ITEM -> createCard()
                OperationCode.SHOW_ALL_ITEMS -> showAllCards()
                OperationCode.REMOVE_CARD -> {
                    println("Type item name: ")
                    val name = readln()
                    removeCardByName(name)
                }

                OperationCode.REGISTER_NEW_EMPLOYEE -> createEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.FIRE_EMPLOYEE -> {
                    println("Type id: ")
                    removeEmployeeById(readln().toInt())
                    writeAllEmployees()
                }

            }
        }
    }

    override fun clean() {
        println("$employeeType $name is cleaning workspace")
    }

    private fun createEmployee() {
        val option = askUserForIntWithMessage(setUpMessageForAskUserInt(
            questionary = "Choose position: ",
            entries = EmployeeType.entries
        ))
        println("Enter id")
        val id = readln().toInt()
        println("Enter name")
        val name = readln()
        println("Enter age")
        val age = readln().toInt()

        val employee: Employee = when (EmployeeType.entries[option]) {
            EmployeeType.ASSISTANT -> Assistant(id = id, name = name, age = age)
            EmployeeType.CONSULTANT -> Consultant(id = id, name = name, age = age)
            EmployeeType.DIRECTOR -> Director(id = id, name = name, age = age)
            EmployeeType.ACCOUNTANT -> Accountant(id = id, name = name, age = age)
        }
        appendEmployeeToFile(employee)
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
        appendCardToFile(card)
    }

    private fun showAllCards() {
        cards = readCardsFromFile()
        for (item in cards) {
            println(item)
            println()
        }
    }

    private fun showAllEmployees() {
        employees = readEmployeesFromFile()
        for (employee in employees) {
            println(employee)
        }
    }

    private fun removeEmployeeById(id: Int) {
        employees = readEmployeesFromFile()
        for (employee in employees) {
            if (employee.id == id) {
                employees.remove(employee)
                break
            }
        }
        writeAllEmployees()
    }

    private fun removeCardByName(name: String) {
        cards = readCardsFromFile()
        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        writeAllCards()
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

    private fun readCardsFromFile(): MutableList<ProductCard> {
        val items = mutableListOf<ProductCard>()

        if (!productCardsFile.exists()) productCardsFile.createNewFile()

        val lines = productCardsFile.readLines()

        if (lines.isEmpty()) return items

        for (line in lines) {
            if (line == "") continue

            val properties = line.trim().split("%")
            val productType = properties.last()

            // Common for Product cards
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()

            when (ProductType.valueOf(productType)) {
                ProductType.GROCERIES -> {
                    val isPacked = properties[3].toBoolean()
                    val number = properties[4].toInt()
                    items.add(GroceriesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        isPacked = isPacked,
                        number = number
                    ))
                }
                ProductType.APPLIANCES -> {
                    val power = properties[3].toInt()
                    items.add(HouseholdAppliancesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        power = power
                    ))
                }
                ProductType.SHOES -> {
                    val size = properties[3].toFloat()
                    items.add(ShoesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        size = size
                    ))
                }
            }
        }
        return items
    }

    fun readEmployeesFromFile(): MutableList<Employee> {
        val employeeList: MutableList<Employee> = mutableListOf()

        if (!employeesFile.exists()) employeesFile.createNewFile()

        val employeeLines = employeesFile.readLines()

        if (employeeLines.isEmpty()) return employeeList

        for (line in employeeLines) {
            if (line == "") continue
            val properties = line.trim().split("%")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val employeeType = properties[3]

            val employee = when (EmployeeType.valueOf(employeeType)) {
                EmployeeType.ASSISTANT -> Assistant(id = id, name = name, age = age)
                EmployeeType.CONSULTANT -> Consultant(id = id, name = name, age = age)
                EmployeeType.DIRECTOR -> Director(id = id, name = name, age = age)
                EmployeeType.ACCOUNTANT -> Accountant(id = id, name = name, age = age)
            }
            employeeList.add(employee)
        }
        return employeeList
    }

    private fun writeAllCards() {
        productCardsFile.writeText("")
        for (card in cards) {
            appendCardToFile(card)
        }
    }

    private fun appendCardToFile(card: ProductCard) {
        productCardsFile.appendText(card.serialize())
        productCardsFile.appendText("\n")
    }

    private fun appendEmployeeToFile(employee: Employee) {
        employeesFile.appendText(employee.serialize())
        employeesFile.appendText("\n")
    }

    private fun writeAllEmployees() {
        employeesFile.writeText("")
        for (employee in employees) {
            appendEmployeeToFile(employee)
        }
    }

    override fun buyThings() {
        println("$employeeType $name is buying things")
    }
}
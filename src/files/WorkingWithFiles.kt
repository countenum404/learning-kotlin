package files

import java.io.File;

enum class OperationCode(
    val title: String
) {
    EXIT("Exit"), NEW_TASK("New Task"), LIST("List")
}

fun setUpOnSelectOperationMessage(): String {
    var options = "Enter operation code: "
    for ((index, value) in OperationCode.entries.withIndex()) {
        options += "$index - ${value.title}"
        options += if (index < OperationCode.entries.size - 1) ", " else ":"
    }
    return options
}

fun printTasks(tasks: List<String>) {
    for ((index, task) in tasks.withIndex()) {
        println("$index - $task")
    }
}

fun main() {
    val file = File("taskList.txt")

    var tasks = file.readText().trim().split("\n")

    while (true) {
        println(setUpOnSelectOperationMessage())
        val opt = readln().toInt()
        val operation = OperationCode.entries[opt]
        when (operation) {
            OperationCode.EXIT -> break
            OperationCode.NEW_TASK -> {
                val task = readln()
                file.appendText("$task\n")
            }

            OperationCode.LIST -> {
                tasks = file.readText().trim().split("\n")
                printTasks(tasks)
            }
        }
    }

}
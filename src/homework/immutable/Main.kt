package homework.immutable

import files.printTasks

enum class Operation {
    SHOW, ADD, REMOVE, REMOVE_AT
}

fun showList(listUser: List<String>) {
    for (user in listUser) {
        println(user)
    }
}



fun task(listUser: List<String>) : List<String> {
    val users = listUser.toMutableList()
    val option = readln()
    when (option) {
        "SHOW" -> showList(users)
        "ADD" -> {
            users.add(readln())
            showList(users)
        }
        "REMOVE" -> {
            users.remove(readln())
            showList(users)
        }
        "REMOVE_AT" -> {
            users.removeAt(readln().toInt())
            showList(users)
        }
        else -> println("Некорректное значение")
    }
    return users.toList()
}

fun main() {
    val l = listOf<String>("user0",
            "user1",
            "user2",
            "user3",
            "user4",
            "user5",
            "user6",
            "user7",
            "user8",
            "user9")
    val list = task(l)
    list.forEach { i -> println(i) }
}
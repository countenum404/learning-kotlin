package homework.nullable

data class UserData(
    val name: String?,
    val email: String?,
    val age: Int?
)

interface Repository {
    /**
     * Возвращает список пользователей, некоторые элементы или их поля могут быть null.
     */
    fun getUsers(): List<UserData?>
}

class UserViewModel(private val repository: Repository) {
    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String> {
        val users = mutableListOf<String>()
        for (user in repository.getUsers()) {
            if (user == null) continue

            val name = if (user.name == null) "Unknown Name" else user.name
            val email = if (user.email == null) "Unknown Email" else user.email
            val age = if (user.age == null) 0 else user.age
            users.add("Name: $name, Email: $email, Age: $age")
        }
        return users
    }
}
package homework.nothing

import corporation.throwDirectorIsRequired

/**
 * Класс NumberValidator выполняет проверку чисел.
 */
object NumberValidator {

    /**
     * Завершает выполнение программы или выбрасывает исключение с заданным сообщением.
     * Возвращает тип Nothing.
     */
    fun terminate(message: String): Nothing {
        throw IllegalArgumentException(message)
    }

    /**
     * Проверяет число на корректность.
     * Если число некорректно, вызывает terminate.
     * @return то же число, если данные корректны.
     */
    fun validate(number: Int): Int {
        when {
            number < 0 -> terminate("Ошибка: Число отрицательное.")
            number == 0 -> terminate("Ошибка: Число равно нулю.")
            else -> return number
        }
    }
}

/**
 * Функция обработки числа.
 * Проверяет число с помощью NumberValidator.validate и выводит результат.
 */
fun processNumber(number: Int) {
//    Принимает целое число.
//    Проверяет его с помощью метода validate объекта NumberValidator.
//    Использует блок try-catch для обработки исключений. (Если выброшено исключение, можно обратиться к его свойству message для получения текста ошибки.)
//    Выводит число или сообщение об ошибке, если число некорректное.
    try {
        val validatedNumber = NumberValidator.validate(number)
        println("Число: $validatedNumber")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
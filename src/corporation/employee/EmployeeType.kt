package corporation.employee

import corporation.InputOption

enum class EmployeeType(
    private val title: String
) : InputOption {
    ASSISTANT("Assistant"),
    CONSULTANT("Consultant"),
    DIRECTOR("Director"),
    ACCOUNTANT("Accountant");

    override fun getTitle(): String {
        return title
    }
}
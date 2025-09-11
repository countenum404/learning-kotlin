package corporation

enum class OperationCode(
    private val title: String
) : InputOption {
    EXIT("Exit"),
    REGISTER_NEW_ITEM("Register New Item"),
    SHOW_ALL_ITEMS("Show All"),
    REMOVE_CARD("Remove Item"),
    REGISTER_NEW_EMPLOYEE("Register new employee"),
    FIRE_EMPLOYEE("Fire an employee"),
    SHOW_ALL_EMPLOYEES("Show all employees");

    override fun getTitle(): String {
        return title
    }
}
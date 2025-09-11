package corporation.cards

import corporation.InputOption

enum class ProductType(
    private val title: String
) : InputOption {
    GROCERIES(title = "Groceries"),
    APPLIANCES(title = "Appliances"),
    SHOES(title = "Shoes");

    override fun getTitle(): String {
        return title
    }

}
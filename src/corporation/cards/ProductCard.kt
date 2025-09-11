package corporation.cards

import corporation.cards.ProductType

abstract class ProductCard(
    val name: String = "",
    val brand: String = "",
    val price: Int = 0,
    val productType: ProductType
) {
    abstract fun  printInfo()

    open fun serialize(): String {
        return "$name%$brand%$price"
    }

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price"
    }
}
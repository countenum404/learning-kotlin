package corporation.cards

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

}
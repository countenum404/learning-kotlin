package corporation.cards

abstract class ProductCard(
    open val name: String = "",
    open val brand: String = "",
    open val price: Int = 0,
    open val productType: ProductType
) {
    abstract fun  printInfo()

    open fun serialize(): String {
        return "$name%$brand%$price"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductCard

        if (price != other.price) return false
        if (name != other.name) return false
        if (brand != other.brand) return false
        if (productType != other.productType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = price
        result = 31 * result + name.hashCode()
        result = 31 * result + brand.hashCode()
        result = 31 * result + productType.hashCode()
        return result
    }


}
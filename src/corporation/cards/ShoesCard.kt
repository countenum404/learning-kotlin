package corporation.cards

data class ShoesCard(
    override val name: String = "",
    override val brand: String = "",
    override val price: Int = 0,
    var size: Float = 0.0f,
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    productType = ProductType.SHOES
) {
    override fun printInfo() {
        println("Name: $name\n" +
                "Brand: $brand\n"+
                "Price: $price\n" +
                "Size: $size")
    }

    override fun serialize(): String {
        return "${super.serialize()}%$size%$productType"
    }

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price Size: $size"
    }
}
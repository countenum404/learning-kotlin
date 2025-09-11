package corporation.cards

import corporation.cards.ProductType

class ShoesCard(
    name: String = "",
    brand: String = "",
    price: Int = 0,
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
}
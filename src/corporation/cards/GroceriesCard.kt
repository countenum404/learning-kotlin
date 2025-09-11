package corporation.cards

import corporation.cards.ProductType

class GroceriesCard(
    name: String = "",
    brand: String = "",
    price: Int = 0,
    val isPacked: Boolean = false,
    val number: Int = 0
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    productType = ProductType.GROCERIES
) {
    override fun printInfo() {
        println("Name: $name\n" +
                "Brand: $brand\n"+
                "Price: $price\n" +
                "isPacked: $isPacked\n" +
                "Number: $number")
    }

    override fun serialize(): String {
        return "${super.serialize()}%$isPacked%$number%$productType"
    }

    override fun toString(): String {
        return "${super.toString()} IsPacked: $isPacked Number: $number Product: $productType"
    }
}
package corporation.cards

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
        return "Name: $name Brand: $brand Price: $price\" IsPacked: $isPacked Number: $number Product: $productType"
    }
}
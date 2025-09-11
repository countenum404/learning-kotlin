package corporation.cards

import corporation.cards.ProductType

class HouseholdAppliancesCard(
    name: String = "",
    brand: String = "",
    price: Int = 0,
    val power: Int = 220
): ProductCard(
    name = name,
    brand = brand,
    price = price,
    productType = ProductType.APPLIANCES
) {

    override fun printInfo() {
        println("Name: $name\n" +
                "Brand: $brand\n"+
                "Price: $price\n" +
                "Power: $power")
    }

    override fun serialize(): String {
        return "${super.serialize()}%$power%$productType"
    }
}
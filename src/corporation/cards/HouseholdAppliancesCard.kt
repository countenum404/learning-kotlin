package corporation.cards

data class HouseholdAppliancesCard(
    override val name: String = "",
    override val brand: String = "",
    override val price: Int = 0,
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

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price Power: $power"
    }
}
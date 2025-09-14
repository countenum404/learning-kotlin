package corporation.repository

import corporation.cards.GroceriesCard
import corporation.cards.HouseholdAppliancesCard
import corporation.cards.ProductCard
import corporation.cards.ProductType
import corporation.cards.ShoesCard
import java.io.File

object CardsRepository {
    private val productCardsFile = File("product_cards.txt")
    private val _cards = readCardsFromFile()
    val cards: List<ProductCard>
        get() = _cards.toList()

    fun removeCardByName(name: String) {
        for (card in _cards) {
            if (card.name == name) {
                _cards.remove(card)
                break
            }
        }
    }

    fun save(productCard: ProductCard) {
        _cards.add(productCard)
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (card in _cards) {
            content.append(card.serialize())
            content.append("\n")
        }
        productCardsFile.writeText(content.toString())
    }

    private fun readCardsFromFile(): MutableSet<ProductCard> {
        val items = mutableSetOf<ProductCard>()

        if (!productCardsFile.exists()) productCardsFile.createNewFile()

        val lines = productCardsFile.readLines()

        if (lines.isEmpty()) return items

        for (line in lines) {
            if (line == "") continue

            val properties = line.trim().split("%")
            val productType = properties.last()

            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()

            when (ProductType.valueOf(productType)) {
                ProductType.GROCERIES -> {
                    val isPacked = properties[3].toBoolean()
                    val number = properties[4].toInt()
                    items.add(GroceriesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        isPacked = isPacked,
                        number = number
                    ))
                }
                ProductType.APPLIANCES -> {
                    val power = properties[3].toInt()
                    items.add(HouseholdAppliancesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        power = power
                    ))
                }
                ProductType.SHOES -> {
                    val size = properties[3].toFloat()
                    items.add(ShoesCard(
                        name = name,
                        brand = brand,
                        price = price,
                        size = size
                    ))
                }
            }
        }
        return items
    }

}
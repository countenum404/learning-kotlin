package homework.tools

class ChainSaw(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    val chainSawTireLength: Int,
    val chainLinksCount: Int,
    val chainStep: Double
): PowerTool(
    brand = brand,
    model = model,
    power = power,
    weight = weight,
    cableLength = cableLength,
    price = price
)
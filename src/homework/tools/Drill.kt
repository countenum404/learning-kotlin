package homework.tools

class Drill(
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    val drillChuckDiameter: Int,
    val minRotationSpeed: Int,
    val maxRotationSpeed: Int,
): PowerTool(
    brand = brand,
    model = model,
    power = power,
    weight = weight,
    cableLength = cableLength,
    price = price
)
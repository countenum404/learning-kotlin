package homework.tools

open class PowerTool(
    val brand: String,
    val model: String,
    val power: Int,
    val weight: Double,
    val cableLength: Int,
    val price: Price,
    val voltage: Int = 220,
) {
    open fun turnOn() {

    }
}
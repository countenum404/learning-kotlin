package homework.geometry

class Rectangle(
    name: String,
    val width: Double,
    val height: Double
) : Shape(name = ShapeType.RECTANGLE.title) {
    override fun area(): Double {
        return roundToTwoDecimals(width * height)
    }

    override fun perimeter(): Double {
        return roundToTwoDecimals(2 * width + 2 * height)
    }
}
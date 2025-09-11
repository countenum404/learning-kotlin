package homework.geometry

import kotlin.math.PI

enum class ShapeType (val title: String) {
    CIRCLE("Circle"),
    RECTANGLE("Rectangle")
}


class Circle(
    name: String,
    val radius: Double
): Shape(name = name) {
    override fun area(): Double {
        return PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * PI * radius
    }
}
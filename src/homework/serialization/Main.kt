package homework.serialization

class Car(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
)

fun serialize(car: Car): String {
    return "${car.make}%${car.model}%${car.year}%${car.vin}%${car.color}"
}

fun deserialize(carAsString: String): Car {
    val properties = carAsString.split("%")
    return Car(
        make = properties[0],
        model = properties[1],
        year = properties[2].toInt(),
        vin = properties[3],
        color = properties[4]
    )
}


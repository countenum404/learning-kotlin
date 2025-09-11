package homework.constructor

fun task() {
    val list = readln().split(" ")
    val deliveryObject = DeliveryObject(list[0].toInt(), list[1].toInt(), list[2].toInt(), list[3].toDouble())
    val warehouse = Warehouse()
    val cargo = warehouse.packCargo(deliveryObject)
    cargo.printInfo()

}

fun main() {
    task()
}
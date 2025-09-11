package homework.constructor

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject) : Pack {
        return Pack(
            length = deliveryObject.length + 1,
            height = deliveryObject.height + 1,
            width = deliveryObject.width + 1,
            type = "Картонная коробка",
            weight = 0.3
        )
    }

    fun packCargo(deliveryObject: DeliveryObject) : Cargo {
        val pack = getPack(deliveryObject)
        return Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePackaging = pack.type,
            netWeight = deliveryObject.weight,
            grossWeight = deliveryObject.weight + pack.weight
        )
    }
}
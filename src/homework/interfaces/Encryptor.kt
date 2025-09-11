package homework.interfaces

class Encryptor: DataProcessor(
    processorName = DataProcessorTypes.ENCRYPTOR.title
), Transformable {
    override fun process(data: String): String {
        return "Обработчик: $processorName обработал данные"
    }

    override fun transform(data: String): String {
        return "$processorName преобразовал данные: encoded_$data"
    }
}
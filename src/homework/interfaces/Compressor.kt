package homework.interfaces

class Compressor: DataProcessor(
    processorName = DataProcessorTypes.COMPRESSOR.title
), Transformable {
    override fun process(data: String): String {
        return "Обработчик: $processorName обработал данные"
    }

    override fun transform(data: String): String {
        return "$processorName преобразовал данные: compressed_$data"

    }
}
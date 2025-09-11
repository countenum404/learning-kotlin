package homework.interfaces

class Logger: DataProcessor(
    processorName = DataProcessorTypes.LOGGER.title
) {
    override fun process(data: String): String {
        return "Обработчик: $processorName обработал данные"
    }
}
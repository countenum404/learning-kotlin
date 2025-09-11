package homework.interfaces

abstract class DataProcessor(
    val processorName: String
) {
    abstract fun process(data: String): String
}
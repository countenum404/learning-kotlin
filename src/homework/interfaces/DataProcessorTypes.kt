package homework.interfaces

enum class DataProcessorTypes(
    val title: String
) {
    ENCRYPTOR("Encryptor"),
    COMPRESSOR("Compressor"),
    LOGGER("Logger")
}
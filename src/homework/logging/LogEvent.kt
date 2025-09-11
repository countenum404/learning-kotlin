package homework.logging

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LogEvent(
    val eventData: Any
) {
    private val date: String = DateTimeFormatter
        .ofPattern("YYYY-MM-DD HH:MM:SS")
        .format(LocalDateTime.now())

    override fun toString(): String {
        return "[$date]: $eventData"
    }
}
package gui

class Rectangle(
    val width: Int = 0,
    val height: Int = 0
) {

    constructor(size: Int) : this(size, size)

    fun draw() {
        for (i in 0..height) {
            for (j in 0..width) {
                print("* ")
            }
            println()
        }
    }
}
package cats

class Lion(val prideMembersCount: Int) : CatsFamily() {
    override fun eat() {
        println("Eating goat")
    }
}
package sorting.compare

abstract class OrderingLogic {

    var comparisonCount = 0

    abstract fun compare(a: Int, b: Int): Boolean

    abstract fun getName(): String

    fun resetCount() {
        comparisonCount = 0
    }
}
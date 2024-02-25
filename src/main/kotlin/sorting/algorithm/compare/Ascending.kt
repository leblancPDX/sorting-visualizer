package sorting.algorithm.compare

class Ascending: OrderingLogic() {

    override fun compare(a: Int, b: Int): Boolean {
        comparisonCount++
        return a > b
    }

    override fun getName(): String {
        return "Ascending Order"
    }
}

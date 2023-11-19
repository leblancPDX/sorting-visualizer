package sorting.compare

class Descending: OrderingLogic() {

    override fun compare(a: Int, b: Int): Boolean {
        comparisonCount++
        return a < b
    }

    override fun getName(): String {
        return "Descending Order"
    }
}
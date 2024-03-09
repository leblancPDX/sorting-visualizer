package sorting.array

class ConsoleArrayPrinter: ArrayListener {

    private val red = "\u001b[31m"

    // Resets previous color codes
    private val reset = "\u001b[0m"

    private var lastIndexes = mutableListOf(-1)

    override fun update(array: Array<ArrayElement>) {
        render(array)
        lastIndexes = mutableListOf()
    }

    override fun update(index: Int) {
        lastIndexes.add(index)
    }

    private fun render(array: Array<ArrayElement>) {
        array.forEachIndexed { index, element ->
            if (lastIndexes.contains(index)) {
                print("$red$element $reset")
            }
            else {
                print("$element ")
            }
        }
        println()
    }
}

package sorting.array

class MonitoredArray(private val array: Array<ArrayElement>): Observable() {

    var size = array.size

    fun notifyOnStart() {
        notifyArrayObservers(stringList())
    }

    operator fun get(index:Int): ArrayElement {
        notifyElementObservers(index)
        return array[index]
    }

    operator fun set(index: Int, value: ArrayElement) {
        array[index] = value
        notifyElementObservers(index)
        notifyArrayObservers(stringList())
    }

    fun swap(i:Int, j:Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        notifyArrayObservers(stringList())
    }

    fun getArray(): Array<ArrayElement> {
        return array
    }

    fun checkArray(other: Array<ArrayElement>): Boolean {
        return array.contentEquals(other)
    }

    private fun stringList(): List<String> {
        return array.map { toString() }
    }

    companion object MonitoredArrayFactory {
        fun createRandomArray(size: Int, ordering: Ordering = Ordering.ASCENDING) : MonitoredArray {
            val array = IntArray(size) { it }
            array.shuffle()
            return when (ordering) {
                Ordering.ASCENDING -> convertToIntAscending(array)
                Ordering.DESCENDING -> convertToIntDescending(array)
            }
        }

        fun createSortedArray(size: Int, ordering: Ordering = Ordering.ASCENDING): MonitoredArray {
            val array = IntArray(size) { it }
            return when (ordering) {
                Ordering.ASCENDING -> convertToIntAscending(array)
                Ordering.DESCENDING -> convertToIntDescending(array)
            }
        }

        fun createReverseSortedArray(size: Int, ordering: Ordering = Ordering.ASCENDING): MonitoredArray {
            val array = IntArray(size) { it }
            array.reverse()
            return when (ordering) {
                Ordering.ASCENDING -> convertToIntAscending(array)
                Ordering.DESCENDING -> convertToIntDescending(array)
            }
        }

        fun createArrayWithFewUniques(size: Int, ordering: Ordering = Ordering.ASCENDING): MonitoredArray {
            val array = IntArray(size) { it / (size / 10) }
            array.shuffle()
            return when (ordering) {
                Ordering.ASCENDING -> convertToIntAscending(array)
                Ordering.DESCENDING -> convertToIntDescending(array)
            }
        }

        private fun convertToIntAscending(array: IntArray) : MonitoredArray {
            val out = array.map { IntAscending(it) }
            return MonitoredArray(out.toTypedArray())
        }

        private fun convertToIntDescending(array: IntArray) : MonitoredArray {
            val out = array.map { IntDescending(it) }
            return MonitoredArray(out.toTypedArray())
        }
    }
}

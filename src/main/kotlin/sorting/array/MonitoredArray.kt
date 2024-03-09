package sorting.array

class MonitoredArray(private val array: Array<ArrayElement>): Observable() {

    var size = array.size

    fun notifyOnStart() {
        notifyArrayObservers(array)
    }

    operator fun get(index:Int): ArrayElement {
        notifyElementObservers(index)
        return array[index]
    }

    operator fun set(index: Int, value: ArrayElement) {
        array[index] = value
        notifyElementObservers(index)
        notifyArrayObservers(array)
    }

    fun swap(i:Int, j:Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        notifyArrayObservers(array)
    }

    fun getArray(): Array<ArrayElement> {
        return array
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MonitoredArray

        if (!array.contentEquals(other.array)) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int {
        var result = array.contentHashCode()
        result = 31 * result + size
        return result
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

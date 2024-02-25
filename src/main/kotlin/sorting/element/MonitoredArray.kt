package sorting.element

class MonitoredArray(private val array: Array<Int>): Observable() {

    var size = array.size

    fun notifyOnStart() {
        notifyArrayObservers(array)
    }

    fun get(index:Int): Int {
        notifyElementObservers(index)
        return array[index]
    }

    fun update(index: Int, value: Int) {
        array[index] = value
        notifyElementObservers(index)
        notifyArrayObservers(array)
    }

    fun swap(i:Int, j:Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        notifyElementObservers(i)
        notifyElementObservers(j)
        notifyArrayObservers(array)
    }

    fun getArray(): Array<Int> {
        return array
    }

    fun checkArray(other: Array<Int>): Boolean {
        return array.contentEquals(other)
    }

    companion object MonitoredArrayFactory {
        fun createRandomArray(size: Int) : MonitoredArray {
            val array = IntArray(size) { it }
            array.shuffle()
            return MonitoredArray(array.toTypedArray())
        }

        fun createSortedArray(size: Int): MonitoredArray {
            val array = IntArray(size) { it }
            return MonitoredArray(array.toTypedArray())
        }

        fun createReverseSortedArray(size: Int): MonitoredArray {
            val array = IntArray(size) { it }
            array.reverse()
            return MonitoredArray(array.toTypedArray())
        }
    }
}

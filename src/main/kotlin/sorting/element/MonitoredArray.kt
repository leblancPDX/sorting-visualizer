package sorting.element

class MonitoredArray(private var array: Array<Int>): Observable() {

    var size = array.size

    fun get(index:Int): Int {
        return array[index]
    }

    fun iterator(): Iterator<Int> {
        return array.iterator()
    }

    fun update(index: Int, value: Int) {
        array[index] = value
        notifyObservers()
    }

    fun swap(i:Int, j:Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
        notifyObservers()
    }

    companion object MonitoredArrayFactory {
        fun createRandomArray(size: Int) : MonitoredArray {
            val array = IntArray(size) { it }
            array.shuffle()
            return MonitoredArray(array.toTypedArray())
        }
    }
}
package sorting.element

class MonitoredArray(private val array: Array<Int>): Observable() {

    val size = array.size

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
}
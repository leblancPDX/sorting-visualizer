package sorting.array

abstract class Observable {
    private val arrayListeners: ArrayList<ArrayListener> = ArrayList()

    fun registerObserver(arrayListener: ArrayListener) {
        arrayListeners.add(arrayListener)
    }

    fun removeObserver(arrayListener: ArrayListener) {
        arrayListeners.remove(arrayListener)
    }

    protected fun notifyArrayObservers(array: Array<ArrayElement>) {
        arrayListeners.forEach { it.update(array) }
    }

    protected fun notifyElementObservers(index: Int) {
        arrayListeners.forEach { it.update(index) }
    }
}

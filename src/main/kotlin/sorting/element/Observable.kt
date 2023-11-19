package sorting.element

import sorting.listener.ArrayListener

abstract class Observable {
    private val arrayListeners: ArrayList<ArrayListener> = ArrayList()

    fun registerObserver(arrayListener: ArrayListener) {
        arrayListeners.add(arrayListener)
    }

    fun removeObserver(arrayListener: ArrayListener) {
        arrayListeners.remove(arrayListener)
    }

    fun notifyObservers() {
        arrayListeners.forEach { it.update() }
    }
}
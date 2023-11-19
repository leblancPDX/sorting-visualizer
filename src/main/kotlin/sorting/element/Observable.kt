package sorting.element

import sorting.listener.Observer

abstract class Observable {
    private val observers: ArrayList<Observer> = ArrayList()

    fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach { it.update() }
    }
}
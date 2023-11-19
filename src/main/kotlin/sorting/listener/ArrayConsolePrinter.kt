package sorting.listener

import sorting.element.MonitoredArray

class ArrayConsolePrinter(val monitoredArray: MonitoredArray): Observer {

    init {
        monitoredArray.registerObserver(this)
    }

    fun render() {
        monitoredArray.iterator().forEach { print(it.toString() + " ") }
        println()
    }

    override fun update() {
        render()
    }
}
package sorting.listener

import sorting.element.MonitoredArray

class ArrayConsolePrinter(val monitoredArray: MonitoredArray): ArrayListener {

    init {
        monitoredArray.registerObserver(this)
        render()
    }

    fun render() {
        monitoredArray.iterator().forEach { print(it.toString() + " ") }
        println()
    }

    override fun update() {
        render()
    }
}
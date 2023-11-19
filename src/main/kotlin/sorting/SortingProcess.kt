package sorting

import sorting.algorithm.InsertionSort
import sorting.compare.Ascending
import sorting.element.MonitoredArray
import sorting.listener.ArrayConsolePrinter

class SortingProcess {

    fun example() {
        val monitoredArray = MonitoredArray.createRandomArray(4)
        ArrayConsolePrinter(monitoredArray)
        val sortingAlgorithm = InsertionSort()
        sortingAlgorithm.sort(monitoredArray, Ascending())
    }
}
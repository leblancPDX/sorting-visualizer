package sorting

import sorting.algorithm.InsertionSort
import sorting.compare.Ascending
import sorting.element.MonitoredArray
import sorting.listener.ConsoleArrayPrinter

class SortingProcess {

    fun example() {
        val monitoredArray = MonitoredArray.createRandomArray(4)
        ConsoleArrayPrinter(monitoredArray)
        val sortingAlgorithm = InsertionSort()
        sortingAlgorithm.sort(monitoredArray, Ascending())
    }
}
package sorting.algorithm

import sorting.element.MonitoredArray

interface SortingAlgorithm {

    fun getName(): String

    fun sort(arr: MonitoredArray): MonitoredArray
}
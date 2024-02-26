package sorting.algorithm

import sorting.array.MonitoredArray

interface SortingAlgorithm {

    fun getName(): String

    fun sort(arr: MonitoredArray): MonitoredArray
}
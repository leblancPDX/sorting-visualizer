package sorting.algorithm

import sorting.compare.OrderingLogic
import sorting.element.MonitoredArray

interface SortingAlgorithm {

    fun sort(arr: MonitoredArray, ordering: OrderingLogic): MonitoredArray

    fun getName(): String
}
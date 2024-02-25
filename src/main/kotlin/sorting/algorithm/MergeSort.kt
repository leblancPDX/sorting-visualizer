package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.element.MonitoredArray

class MergeSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    override fun getName(): String {
        return "Merge Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        TODO("Not yet implemented")
    }

    private fun merge() {

    }
}

package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.element.MonitoredArray

class SelectionSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    override fun getName(): String {
        return "Selection Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (unsortedPartFirstIndex in 0..<arr.size) {
            var minNumberIndex = unsortedPartFirstIndex
            for (unsortedPartCurrentIndex in unsortedPartFirstIndex..<arr.size) {
                if (ordering.compare(arr.get(minNumberIndex), arr.get(unsortedPartCurrentIndex))) {
                    minNumberIndex = unsortedPartCurrentIndex
                }
            }
            arr.swap(unsortedPartFirstIndex, minNumberIndex)
        }
        return arr
    }
}

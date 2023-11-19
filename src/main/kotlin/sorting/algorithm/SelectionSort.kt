package sorting.algorithm

import sorting.compare.OrderingLogic
import sorting.element.MonitoredArray

class SelectionSort : SortingAlgorithm {

    override fun sort(arr: MonitoredArray, ordering: OrderingLogic): MonitoredArray {
        ordering.resetCount()
        for (unsortedPartFirstIndex in 0..<arr.size) {
            var minNumberIndex = unsortedPartFirstIndex
            for (unsortedPartCurrentIndex in unsortedPartFirstIndex..<arr.size) {
                if (ordering.compare(arr.get(minNumberIndex), arr.get(unsortedPartCurrentIndex))) {
                    minNumberIndex = unsortedPartCurrentIndex
                }
            }
            if (minNumberIndex != unsortedPartFirstIndex) {
                arr.swap(unsortedPartFirstIndex, minNumberIndex)
            }
        }
        return arr
    }

    override fun getName(): String {
        return "Selection Sort"
    }
}
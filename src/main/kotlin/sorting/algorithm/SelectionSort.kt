package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.array.MonitoredArray

class SelectionSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    override fun getName(): String {
        return "Selection Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (i in 0..<arr.size) {
            var minElementIndex = i
            for (j in i + 1..<arr.size) {
                if (ordering.compare(arr[minElementIndex], arr[j])) {
                    minElementIndex = j
                }
            }
            arr.swap(i, minElementIndex)
        }
        return arr
    }
}

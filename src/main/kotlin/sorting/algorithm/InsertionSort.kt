package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.array.MonitoredArray

class InsertionSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    override fun getName(): String {
        return "Insertion Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (j in 1..<arr.size) {
            var i = j - 1
            val element = arr[j]
            while (i >= 0 && ordering.compare(arr[i], element)) {
                arr[i + 1] = arr[i]
                i--
            }
            if (i != j - 1) {
                arr[i + 1] = element
            }
        }

        return arr
    }
}
package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.element.MonitoredArray

class InsertionSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    override fun getName(): String {
        return "Insertion Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (j in 1..<arr.size) {
            var i = j - 1
            val element = arr.get(j)
            while (i >= 0 && ordering.compare(arr.get(i), element)) {
                arr.update(i + 1, arr.get(i))
                i--
            }
            if (i != j - 1) {
                arr.update(i + 1, element)
            }
        }

        return arr
    }
}
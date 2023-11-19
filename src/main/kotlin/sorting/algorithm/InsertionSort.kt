package sorting.algorithm

import sorting.compare.OrderingLogic
import sorting.element.MonitoredArray

class InsertionSort : SortingAlgorithm {

    override fun sort(arr: MonitoredArray, ordering: OrderingLogic): MonitoredArray {
        ordering.resetCount()
        for (j in 1..<arr.size) {
            var i = j - 1
            val element = arr.get(j)
            while (i >= 0 && ordering.compare(arr.get(i), element)) {
                arr.update(i + 1, arr.get(i))
                i--
            }
            arr.update(i + 1, element)
        }

        return arr
    }

    override fun getName(): String {
        return "Insertion Sort"
    }
}
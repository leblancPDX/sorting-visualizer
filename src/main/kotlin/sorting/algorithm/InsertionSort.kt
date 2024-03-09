package sorting.algorithm

import sorting.array.MonitoredArray

class InsertionSort : SortingAlgorithm {

    override fun getName() = "Insertion Sort"

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (j in 1 until arr.size) {
            var i = j - 1
            val element = arr[j]
            while (i >= 0 && arr[i] > element) {
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

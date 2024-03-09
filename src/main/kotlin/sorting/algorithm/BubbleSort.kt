package sorting.algorithm

import sorting.array.MonitoredArray

class BubbleSort : SortingAlgorithm {
    override fun getName() = "BubbleSort"

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (i in 0 until arr.size) {
            for (j in 1 until arr.size - i) {
                if (arr[j - 1] > arr[j]) {
                    arr.swap(j, j - 1)
                }
            }
        }
        return arr
    }
}

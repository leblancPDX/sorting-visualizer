package sorting.algorithm

import sorting.array.MonitoredArray

class SelectionSort : SortingAlgorithm {

    override fun getName(): String {
        return "Selection Sort"
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        for (i in 0..<arr.size) {
            var minElementIndex = i
            for (j in i + 1..<arr.size) { // a > b
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j
                }
            }
            arr.swap(i, minElementIndex)
        }
        return arr
    }
}

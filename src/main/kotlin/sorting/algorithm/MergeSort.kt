package sorting.algorithm

import sorting.algorithm.compare.OrderingLogic
import sorting.array.MonitoredArray

class MergeSort(private val ordering: OrderingLogic) : SortingAlgorithm {

    // Initial implementation was taken from here:
    // https://medium.com/@vamsitallapudi/merge-sort-kotlin-implementation-sorting-algorithms-3-2d076f39b55c

    override fun getName(): String {
        return "Merge Sort --> " + ordering.getName()
    }

    override fun sort(arr: MonitoredArray): MonitoredArray {
        mergeSort(arr)
        return arr
    }

    private fun mergeSort(
        arr: MonitoredArray,
        auxArray: IntArray = IntArray(arr.size),
        low: Int = 0,
        high: Int = arr.size - 1
    ) {
        if (low < high) {
            val mid = low + ((high - low) / 2)
            mergeSort(arr, auxArray, low, mid)
            mergeSort(arr, auxArray, mid + 1, high)
            merge(arr, auxArray, low, mid, high)
        }
    }

    private fun merge(arr: MonitoredArray, auxArray: IntArray, low: Int, mid: Int, high: Int) {
        for (i in low..high) {
            auxArray[i] = arr[i]
        }

        var auxLeft = low
        var auxRight = mid + 1
        var current = low

        while (auxLeft <= mid && auxRight <= high) {
            if (ordering.compare(auxArray[auxLeft], auxArray[auxRight])) {
                arr[current] = auxArray[auxRight]
                auxRight++
            } else {
                arr[current] = auxArray[auxLeft]
                auxLeft++
            }
            current++
        }

        for (i in 0..mid - auxLeft) {
            arr[current + i] = auxArray[auxLeft + i]
        }
    }
}

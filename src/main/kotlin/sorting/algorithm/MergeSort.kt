package sorting.algorithm

import sorting.array.ArrayElement
import sorting.array.MonitoredArray

class MergeSort : SortingAlgorithm {

    // Initial implementation was taken from here:
    // https://medium.com/@vamsitallapudi/merge-sort-kotlin-implementation-sorting-algorithms-3-2d076f39b55c

    override fun getName() = "Merge Sort"

    override fun sort(arr: MonitoredArray): MonitoredArray {
        mergeSort(arr)
        return arr
    }

    private fun mergeSort(
        arr: MonitoredArray,
        auxArray: Array<ArrayElement?> = arrayOfNulls(arr.size),
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

    private fun merge(arr: MonitoredArray, auxArray: Array<ArrayElement?>, low: Int, mid: Int, high: Int) {
        for (i in low..high) {
            auxArray[i] = arr[i]
        }

        var auxLeft = low
        var auxRight = mid + 1
        var current = low

        while (auxLeft <= mid && auxRight <= high) {
            if (auxArray[auxLeft]!! > auxArray[auxRight]!!) {
                arr[current] = auxArray[auxRight]!!
                auxRight++
            } else {
                arr[current] = auxArray[auxLeft]!!
                auxLeft++
            }
            current++
        }

        for (i in 0..mid - auxLeft) {
            arr[current + i] = auxArray[auxLeft + i]!!
        }
    }
}

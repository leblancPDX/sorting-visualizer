package sorting.algorithm

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sorting.algorithm.compare.Ascending
import sorting.algorithm.compare.Descending
import sorting.array.MonitoredArray

class MergeSortTest {

    @Test
    fun `should return a sorted array given a shuffled array and ascending ordering logic`() {
        val size = 10
        val sortingAlgorithm = MergeSort(Ascending())
        val arr = sortingAlgorithm.sort(MonitoredArray.createRandomArray(size))
        val expected = MonitoredArray.createSortedArray(size)
        assertTrue(arr.checkArray(expected.getArray()))
    }

    @Test
    fun `should return a reverse sorted array given a shuffled array and descending ordering logic`() {
        val size = 10
        val sortingAlgorithm = MergeSort(Descending())
        val arr = sortingAlgorithm.sort(MonitoredArray.createRandomArray(size))
        val expected = MonitoredArray.createReverseSortedArray(size)
        assertTrue(arr.checkArray(expected.getArray()))
    }

    @Test
    fun `should return an unchanged array given a sorted array and ascending ordering logic`() {
        val size = 10
        val sortingAlgorithm = MergeSort(Ascending())
        val arr = sortingAlgorithm.sort(MonitoredArray.createSortedArray(size))
        val expected = MonitoredArray.createSortedArray(size)
        assertTrue(arr.checkArray(expected.getArray()))
    }
}
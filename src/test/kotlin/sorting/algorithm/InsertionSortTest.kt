package sorting.algorithm

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sorting.array.MonitoredArray
import sorting.array.Ordering

class InsertionSortTest {

    @Test
    fun `should return a sorted array given a shuffled array and ascending ordering logic`() {
        val size = 10
        val sortingAlgorithm = InsertionSort()
        val arr = sortingAlgorithm.sort(MonitoredArray.createRandomArray(size))
        val expected = MonitoredArray.createSortedArray(size)
        assertEquals(expected, arr)
    }

    @Test
    fun `should return a reverse sorted array given a shuffled array and descending ordering logic`() {
        val size = 10
        val sortingAlgorithm = InsertionSort()
        val arr = sortingAlgorithm.sort(MonitoredArray.createRandomArray(size, Ordering.DESCENDING))
        val expected = MonitoredArray.createReverseSortedArray(size)
        assertEquals(expected, arr)
    }

    @Test
    fun `should return an unchanged array given a sorted array and ascending ordering logic`() {
        val size = 10
        val sortingAlgorithm = InsertionSort()
        val arr = sortingAlgorithm.sort(MonitoredArray.createSortedArray(size))
        val expected = MonitoredArray.createSortedArray(size)
        assertEquals(expected, arr)
    }
}

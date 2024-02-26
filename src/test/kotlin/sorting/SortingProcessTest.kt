package sorting

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import sorting.algorithm.InsertionSort
import sorting.algorithm.MergeSort
import sorting.algorithm.SelectionSort
import sorting.algorithm.compare.Ascending
import sorting.array.MonitoredArray
import sorting.array.ArrayListener
import kotlin.test.Test

class SortingProcessTest {

    @Test
    fun `should notify on start and on each update given a non-empty array`() {
        val mockListener = mockk<ArrayListener>()
        justRun { mockListener.update(any<IntArray>()) }
        justRun { mockListener.update(any<Int>()) }
        val orderingLogic = Ascending()
        val sortingProcess = SortingProcess(SelectionSort(orderingLogic), mockListener)
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createSortedArray(3))
        assertTrue(millis >= 0)
        assertEquals(3, orderingLogic.comparisonCount)
        verify(exactly = 4) { mockListener.update(any<IntArray>()) }
        verify(exactly = 6) { mockListener.update(any<Int>()) }
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and InsertionSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(InsertionSort(Ascending()))
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createReverseSortedArray(10))
        assertTrue(millis >= 0)
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and SelectionSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(SelectionSort(Ascending()))
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createRandomArray(10))
        assertTrue(millis >= 0)
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and MergeSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(MergeSort(Ascending()))
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createRandomArray(10))
        assertTrue(millis >= 0)
    }
}
package sorting

import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import sorting.algorithm.BubbleSort
import sorting.algorithm.InsertionSort
import sorting.algorithm.MergeSort
import sorting.algorithm.SelectionSort
import sorting.array.ArrayElement
import sorting.array.MonitoredArray
import sorting.array.ArrayListener
import kotlin.test.Test

class SortingProcessTest {

    @Test
    fun `should notify on start and on each update given a non-empty array`() {
        val mockListener = mockk<ArrayListener>()
        justRun { mockListener.update(any<Array<ArrayElement>>()) }
        justRun { mockListener.update(any<Int>()) }
        val sortingProcess = SortingProcess(SelectionSort(), mockListener)
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createSortedArray(3))
        assertTrue(millis >= 0)
        verify(exactly = 4) { mockListener.update(any<Array<ArrayElement>>()) }
        verify(exactly = 6) { mockListener.update(any<Int>()) }
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and InsertionSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(InsertionSort())
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createReverseSortedArray(10))
        assertTrue(millis >= 0)
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and SelectionSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(SelectionSort())
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createRandomArray(10))
        assertTrue(millis >= 0)
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and MergeSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(MergeSort())
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createRandomArray(10))
        assertTrue(millis >= 0)
    }

    @Test
    fun `should print to console when using ConsoleArrayPrinter and BubbleSort`() {
        val sortingProcess = SortingProcess.createSortingProcessWithConsolePrinter(BubbleSort())
        val millis = sortingProcess.timeSortingAlgorithm(MonitoredArray.createRandomArray(10))
        assertTrue(millis >= 0)
    }
}

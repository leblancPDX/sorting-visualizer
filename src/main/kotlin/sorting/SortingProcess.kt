package sorting

import sorting.algorithm.SortingAlgorithm
import sorting.array.MonitoredArray
import sorting.array.ArrayListener
import sorting.array.ConsoleArrayPrinter
import kotlin.system.measureNanoTime

class SortingProcess(private val sortingAlgorithm: SortingAlgorithm, private val arrayListener: ArrayListener) {

    fun timeSortingAlgorithm(monitoredArray: MonitoredArray): Long {
        println(sortingAlgorithm.getName())
        monitoredArray.registerObserver(arrayListener)
        monitoredArray.notifyOnStart()
        return measureNanoTime {
            sortingAlgorithm.sort(monitoredArray)
        } / 1_000_000 // Converting nano seconds into millis
    }

    companion object SortingProcessFactory {
        fun createSortingProcessWithConsolePrinter(algorithm: SortingAlgorithm): SortingProcess {
            return SortingProcess(algorithm, ConsoleArrayPrinter())
        }
    }
}

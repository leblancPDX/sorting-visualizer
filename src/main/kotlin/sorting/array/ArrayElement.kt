package sorting.array

abstract class ArrayElement(val element: Int) {
    override fun toString(): String {
        return "$element"
    }
}

class IntAscending(element: Int) : ArrayElement(element) {
    operator fun compareTo(other: ArrayElement): Int = element compareTo other.element
}

class IntDescending(element: Int) : ArrayElement(element) {
    operator fun compareTo(other: ArrayElement): Int = other.element compareTo element
}

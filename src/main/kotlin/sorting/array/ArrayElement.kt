package sorting.array

abstract class ArrayElement(val element: Int) {

    abstract operator fun compareTo(other: ArrayElement): Int

    override fun toString(): String {
        return "$element"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ArrayElement) return false

        if (element != other.element) return false

        return true
    }

    override fun hashCode(): Int {
        return element
    }
}

class IntAscending(element: Int) : ArrayElement(element) {
    override operator fun compareTo(other: ArrayElement): Int = element compareTo other.element
}

class IntDescending(element: Int) : ArrayElement(element) {
    override operator fun compareTo(other: ArrayElement): Int = other.element compareTo element
}

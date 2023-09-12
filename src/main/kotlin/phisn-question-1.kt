import kotlin.math.max

fun notIncreasingFromTwo(a: IntArray, b: IntArray): Int {
    assert(a.size == b.size)
    assert(a.isNotEmpty())
    var current = 1
    val processingIntervals = mutableMapOf<Int, MutableList<Int>>()
    val finishedIntervals = mutableMapOf<Int, MutableList<Int>>()

    while (current < a.size) {
        processingIntervals.forEach { (first, list) ->
            val last = list.last()
            if (a[current] > last && b[current] > last) {
                finishedIntervals[first] = list
            }
        }
        finishedIntervals.forEach { (k, _) -> processingIntervals.remove(k) }
        val aValid = a[current] <= a[current - 1] || a[current] <= b[current - 1]
        val bValid = b[current] <= b[current - 1] || b[current] <= a[current - 1]
        if (aValid || bValid) {
            processingIntervals.computeIfAbsent(current - 1) { _ ->
                mutableListOf(
                    max(a[current - 1], b[current - 1])
                )
            }
            processingIntervals.forEach { (_, list) ->
                val last = list.last()
                if (aValid && !bValid && a[current] <= last) {
                    list += a[current]
                } else if (bValid && !aValid && b[current] <= last) {
                    list += b[current]
                } else {
                    val max = max(a[current], b[current])
                    if (max <= last) {
                        list += max
                    }
                }
            }
        }

        current++
        if (current == a.size) {
            processingIntervals.forEach { (k, v) -> finishedIntervals[k] = v }
        }
    }
    println("Intervals:\n${finishedIntervals.toList().joinToString("\n")}")
    return finishedIntervals.maxOf { (_, b) -> b.size }
}

fun main() {
    val a = intArrayOf(1, 4, 3, 4, 9)
    val b = intArrayOf(1, 1, 2, 2, 10)
    println(notIncreasingFromTwo(a, b))

    val c = intArrayOf(1, 3, 5, 1, 4, 4, 3, 3)
    val d = intArrayOf(0, 2, 2, 5, 0, 8, 3, 3)
    println(notIncreasingFromTwo(c, d))
}

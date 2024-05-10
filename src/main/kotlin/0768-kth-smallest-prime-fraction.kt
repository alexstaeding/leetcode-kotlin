fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    if (arr.size == 2) {
        return arr
    }
    val pairs = IntArray(arr.size - 1) { arr.lastIndex }
    var maxLeft = 0
    var lastBest = 0
    repeat(k) {
        val best = (0..maxLeft + 1)
            .minBy { arr[it].toDouble() / arr[pairs[it]].toDouble() }
        maxLeft = kotlin.math.min(kotlin.math.max(maxLeft, best + 1), arr.lastIndex - 2)
        pairs[best]--
        lastBest = best
    }
    return intArrayOf(arr[lastBest], arr[pairs[lastBest] + 1])
}

fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    if (k == 1) {
        return intArrayOf(arr.first(), arr.last())
    }
    val pairs = IntArray(arr.size - 1) { arr.lastIndex }
    var maxLeft = 0
    var lastBest = 0
    repeat(k) {
        val best = (0..maxLeft + 1).minBy { arr[it].toDouble() / arr[pairs[it]].toDouble() }
        if (best > maxLeft && best < arr.lastIndex - 1) {
            maxLeft = best
        }
        pairs[best]--
        lastBest = best
    }
    return intArrayOf(arr[lastBest], arr[pairs[lastBest] + 1])
}

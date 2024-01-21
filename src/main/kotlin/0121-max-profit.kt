fun maxProfit(prices: IntArray): Int {
    var min = Int.MAX_VALUE
    var maxDiff = 0
    for (i in prices) {
        if (i < min) {
            min = i
        }
        if (i - min > maxDiff) {
            maxDiff = i - min
        }
    }
    return maxDiff
}

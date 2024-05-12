fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    val ratios = MutableList(quality.size) { wage[it].toDouble() / quality[it].toDouble() to it }
    ratios.sortBy { (ratio) -> ratio }
    var maxRate = 0.0
    var sum = 0
    val queue = java.util.PriorityQueue<Int>(Comparator.reverseOrder())
    for (i in 0..<k) {
        sum += quality[ratios[i].second]
        maxRate = maxOf(maxRate, ratios[i].first)
        queue.add(quality[ratios[i].second])
    }

    var res = maxRate * sum

    for (i in k..<quality.size) {
        maxRate = maxOf(maxRate, ratios[i].first)
        sum -= queue.poll()

        sum += quality[ratios[i].second]
        queue.add(quality[ratios[i].second])
        res = minOf(res, maxRate * sum)
    }

    return res
}

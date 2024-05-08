fun findRelativeRanks(score: IntArray): Array<String> {
    val queue = java.util.PriorityQueue<IndexedValue<Int>>(score.size) { (_, l), (_, r) -> r - l }
    score.withIndex().forEach { queue.add(it) }

    val result = Array(score.size) { "" }
    for (i in score.indices) {
        val (athleteIndex, _) = queue.poll()
        result[athleteIndex] = when (i) {
            0 -> "Gold Medal"
            1 -> "Silver Medal"
            2 -> "Bronze Medal"
            else -> (i + 1).toString()
        }
    }

    return result
}

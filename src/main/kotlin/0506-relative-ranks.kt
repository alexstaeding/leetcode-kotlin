fun findRelativeRanks(score: IntArray): Array<String> {
    val result = Array(score.size) { "" }
    score.withIndex()
        .sortedByDescending { it.value }
        .map { it.index }
        .forEachIndexed { placement, athleteIndex ->
            result[athleteIndex] = when (placement) {
                0 -> "Gold Medal"
                1 -> "Silver Medal"
                2 -> "Bronze Medal"
                else -> (placement + 1).toString()
            }
        }
    return result
}

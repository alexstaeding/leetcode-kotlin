fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    val queue = java.util.PriorityQueue<Int>(happiness.size, Comparator.reverseOrder())
    happiness.forEach { queue.add(it) }
    return generateSequence { queue.poll().toLong() }
        .take(k)
        .mapIndexed { index, v -> (v - index).coerceAtLeast(0) }
        .sum()
}

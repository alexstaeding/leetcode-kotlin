fun findMaxK(nums: IntArray): Int {
    val negatives = java.util.PriorityQueue<Int>()
    val positives = java.util.PriorityQueue<Int>(Comparator.reverseOrder())
    for (num in nums) {
        // No 0s in input
        if (num < 0) {
            negatives.add(num)
        } else {
            positives.add(num)
        }
    }
    var topNeg = negatives.poll() ?: return -1
    var topPos = positives.poll() ?: return -1

    while (true) {
        when {
            topPos == -topNeg -> return topPos
            topPos > -topNeg -> topPos = positives.poll() ?: return -1
            -topNeg > topPos -> topNeg = negatives.poll() ?: return -1
        }
    }
}

// Shorter, but worse performance:
// val numSet = nums.toSet()
// return nums.asSequence().filter { -it in numSet }.maxOrNull() ?: -1

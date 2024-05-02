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
    var topNeg = negatives.poll()
    var topPos = positives.poll()

    while (true) {
        println("$topNeg $topPos")
        if (topPos == -topNeg) {
            return topPos
        }

        if (topPos > -topNeg) {
            topPos = positives.poll() ?: return -1
        } else if (-topNeg > topPos) {
            topNeg = negatives.poll() ?: return -1
        }
    }
}

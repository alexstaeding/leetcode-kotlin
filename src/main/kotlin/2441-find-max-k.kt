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
    println("Negatives: $negatives")
    println("Positives: $positives")
    val neg = negatives.iterator()
    val pos = positives.iterator()

    var topNeg = neg.next()
    var topPos = pos.next()

    while (neg.hasNext() && pos.hasNext()) {
        if (topPos == -topNeg) {
            return topPos
        }

        if (topPos > -topNeg) {
            topPos = pos.next()
        } else if (-topNeg > topPos) {
            topNeg = neg.next()
        }
    }

    return -1
}

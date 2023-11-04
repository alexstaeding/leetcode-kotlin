fun trap(height: IntArray): Int {
    var currentHeight = height.max()
    var totalWater = 0
    while (currentHeight > 0) {
        // get positions of columns that are at least this tall
        val columns = height
            .asSequence()
            .withIndex()
            .filter { (_, h) -> h >= currentHeight }
            .map { (i, _) -> i }
            .toSet()

        currentHeight--

        if (columns.size == 1) {
            continue
        }

        for (i in columns.min() .. columns.max()) {
            if (i !in columns) {
                totalWater++
            }
        }
    }
    return totalWater
}

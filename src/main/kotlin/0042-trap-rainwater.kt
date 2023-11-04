fun trap(height: IntArray): Int {
    var currentHeight = height.max()
    var totalWater = 0
    val columns = mutableSetOf<Int>()
    while (currentHeight > 0) {
        // get positions of columns that are at least this tall

        for (i in height.indices) {
            if (height[i] == currentHeight) {
                columns.add(i)
            }
        }

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

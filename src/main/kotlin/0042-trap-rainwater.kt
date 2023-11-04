fun trap(height: IntArray): Int {
    var currentHeight = height.max()
    var totalWater = 0
    var left = height.size - 1
    var right = 0
    val columns = mutableSetOf<Int>()
    while (currentHeight > 0) {
        // get positions of columns that are at least this tall

        for (i in height.indices) {
            if (height[i] >= currentHeight) {
                if (i < left) {
                    left = i
                } else if (i > right) {
                    right = i
                }
                if (height[i] == currentHeight) {
                    columns.add(i)
                }
            }
        }

        currentHeight--

        if (columns.size == 1) {
            continue
        }

        for (i in left .. right) {
            if (i !in columns) {
                totalWater++
            }
        }
    }
    return totalWater
}

fun findFarmland(land: Array<IntArray>): Array<IntArray> {
    val results = mutableListOf<IntArray>()
    for ((y, row) in land.withIndex()) {
        for ((x, cell) in row.withIndex()) {
            // only top left corners of farm land
            if (cell == 0 ||
                !(y == 0 || land[y - 1][x] == 0) ||
                !(x == 0 || land[y][x - 1] == 0)
            ) continue

            // check number of 1s to the right
            val xSize = generateSequence(1) { it + 1 }
                .takeWhile { x + it < land[y].size && land[y][x + it] == 1 }
                .count()

            // check number of 1s downwards
            val ySize = generateSequence(1) { it + 1 }
                .takeWhile { y + it < land.size && land[y + it][x] == 1 }
                .count()

            results.add(intArrayOf(y, x, y + ySize, x + xSize))
        }
    }
    return results.toTypedArray()
}

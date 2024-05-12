fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    val result = Array(grid.size - 2) { y -> IntArray(grid[y].size - 2) }
    for (y in 0..<grid.size - 2) {
        for (x in 0..<grid[y].size - 2) {
            var max = 0
            for (yS in y..y + 2) {
                for (xS in x..x + 2) {
                    max = maxOf(max, grid[yS][xS])
                }
            }
            result[y][x] = max
        }
    }
    return result
}

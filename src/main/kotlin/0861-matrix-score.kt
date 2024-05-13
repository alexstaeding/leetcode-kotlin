fun matrixScore(grid: Array<IntArray>): Int {
    for (row in grid) {
        if (row[0] == 0) {
            for (x in row.indices) {
                row[x] = 1 - row[x]
            }
        }
    }
    for (x in grid[0].indices) {
        var zeroCount = 0
        for (y in grid.indices) {
            if (grid[y][x] == 0) {
                zeroCount++
            }
        }
        if (zeroCount > grid.size / 2) {
            for (y in grid.indices) {
                grid[y][x] = 1 - grid[y][x]
            }
        }
    }
    return grid.sumOf { row ->
        row.fold<Int>(0) { acc, i -> (acc shl 1) + i }
    }
}

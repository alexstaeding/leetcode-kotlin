private data class MaximumGoldPos(val x: Int, val y: Int)
private data class MaximumGoldNode(val pos: MaximumGoldPos, val prev: MaximumGoldNode? = null)

private operator fun Array<IntArray>.get(pos: MaximumGoldPos): Int = this[pos.y][pos.x]

fun getMaximumGold(grid: Array<IntArray>): Int {
    val queue = ArrayDeque<MaximumGoldNode>()
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid[y][x] == 0) {
                continue
            }
            queue.add(MaximumGoldNode(MaximumGoldPos(x, y)))
        }
    }

    var best = 0
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        var addedToQueue = false
        for (dy in -1..1) {
            for (dx in -1..1) {
                if (dy == 0 && dx == 0 || ((dy == 0) == (dx == 0))) continue
                val pos = MaximumGoldPos(current.pos.x + dx, current.pos.y + dy)
                if (pos.y !in grid.indices ||
                    pos.x !in grid[pos.y].indices ||
                    grid[pos.y][pos.x] == 0 || generateSequence(current) { it.prev }.any { it.pos == pos }
                ) continue
                queue.add(MaximumGoldNode(pos, current))
                addedToQueue = true
            }
        }
        if (!addedToQueue) {
            // reached end
            val score = generateSequence(current) { it.prev }.sumOf { grid[it.pos] }
            if (score > best) {
                best = score
            }
        }
    }

    return best
}

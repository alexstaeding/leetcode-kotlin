import java.util.PriorityQueue

fun generateSafeness(grid: List<List<Int>>): List<List<Int>> {
    data class Pos(val x: Int, val y: Int)

    val thieves = mutableListOf<Pos>()
    grid.forEachIndexed { y, row ->
        row.forEachIndexed { x, value ->
            if (value == 1) thieves.add(Pos(x, y))
        }
    }

    val safeness = MutableList(grid.size) { MutableList(grid[0].size) { 0 } }
    val alreadySet = HashSet<Pos>(grid.size * grid[0].size)
    val currentRound = ArrayDeque<Pos>(grid.size * grid[0].size)
    currentRound.addAll(thieves)
    alreadySet.addAll(thieves)
    var roundNumber = 0

    while (currentRound.isNotEmpty()) {
        val size = currentRound.size
        repeat(size) {
            val pos = currentRound.removeFirst()
            safeness[pos.y][pos.x] = roundNumber
            listOf(
                Pos(pos.x, pos.y + 1),
                Pos(pos.x + 1, pos.y),
                Pos(pos.x - 1, pos.y),
                Pos(pos.x, pos.y - 1)
            ).forEach { candidate ->
                if (candidate.x in grid[0].indices && candidate.y in grid.indices && candidate !in alreadySet) {
                    currentRound.addLast(candidate)
                    alreadySet.add(candidate)
                }
            }
        }
        roundNumber++
    }
    return safeness
}

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    data class Pos(val x: Int, val y: Int)
    data class PathPos(val pos: Pos, val safenessSoFar: Int)

    val safeness = generateSafeness(grid)
    val target = Pos(grid[0].size - 1, grid.size - 1)
    val visited = HashSet<Pos>()
    val queue = PriorityQueue(compareBy<PathPos> { -it.safenessSoFar })
    queue.add(PathPos(Pos(0, 0), safeness[0][0]))

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (!visited.add(current.pos)) continue
        if (current.pos == target) return current.safenessSoFar
        listOf(
            Pos(current.pos.x, current.pos.y + 1),
            Pos(current.pos.x + 1, current.pos.y),
            Pos(current.pos.x - 1, current.pos.y),
            Pos(current.pos.x, current.pos.y - 1)
        ).forEach { pos ->
            if (pos !in visited && pos.x in grid[0].indices && pos.y in grid.indices) {
                queue.add(PathPos(pos, minOf(current.safenessSoFar, safeness[pos.y][pos.x])))
            }
        }
    }
    return 0
}

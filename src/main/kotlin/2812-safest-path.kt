import kotlin.math.abs


fun generateSafeness(grid: List<List<Int>>): List<List<Int>> {
    data class Pos(val x: Int, val y: Int)

    val thieves: List<Pos> = grid.map { it.withIndex() }.withIndex()
        .flatMap { (y, v) -> v.filter { it.value == 1 }.map { (x) -> Pos(x, y) } }

    val safeness = MutableList(grid.size) { MutableList(grid.size) { 0 } }
    val alreadySet = LinkedHashSet<Pos>(grid.size * grid.size)
    var currentRound = LinkedHashSet<Pos>(grid.size * grid.size)
    currentRound.addAll(thieves)
    alreadySet.addAll(thieves)
    var roundNumber = 0
    while (currentRound.isNotEmpty()) {
        val nextRound = LinkedHashSet<Pos>()
        for (pos in currentRound) {
            safeness[pos.y][pos.x] = roundNumber
            sequenceOf(
                pos.copy(y = pos.y + 1),
                pos.copy(x = pos.x + 1),
                pos.copy(x = pos.x - 1),
                pos.copy(y = pos.y - 1),
            ).filter { candidate ->
                candidate.x in grid.indices && candidate.y in grid.indices &&
                    candidate !in alreadySet
            }.forEach {
                nextRound.add(it)
                alreadySet.add(it)
            }
        }
        currentRound = nextRound
        roundNumber++

    }
    return safeness
}

fun maximumSafenessFactor(grid: List<List<Int>>): Int {

    val safeness = generateSafeness(grid)

    data class Pos(val x: Int, val y: Int) {
        fun manhattan(other: Pos) = abs(x - other.x) + abs(y - other.y)
        override fun toString(): String = "($x, $y)"
    }

    data class PathPos(val pos: Pos, val safenessSoFar: Int)

    operator fun List<List<Int>>.get(pos: Pos) = this[pos.y][pos.x]

    val target = Pos(grid.size - 1, grid.size - 1)

    val visited = mutableSetOf<Pos>()

    val queue = java.util.PriorityQueue(
        Comparator.comparing<PathPos, Int> { -it.safenessSoFar })

    queue.add(PathPos(Pos(0, 0), safeness[0][0]))

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        visited.add(current.pos)
        if (current.pos == target) {
            println("Found: $current")
            return current.safenessSoFar
        }
        sequenceOf(
            current.pos.copy(y = current.pos.y + 1),
            current.pos.copy(x = current.pos.x + 1),
            current.pos.copy(x = current.pos.x - 1),
            current.pos.copy(y = current.pos.y - 1),
        ).filter { candidate ->
            candidate !in visited && candidate.x in grid.indices && candidate.y in grid.indices
        }.forEach { pos ->
            queue.add(PathPos(pos, minOf(current.safenessSoFar, safeness[pos])))
        }
    }
    return 0
}

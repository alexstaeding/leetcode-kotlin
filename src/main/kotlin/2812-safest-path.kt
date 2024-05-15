import kotlin.math.abs

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    data class Pos(val x: Int, val y: Int) {
        fun manhattan(other: Pos) = abs(x - other.x) + abs(y - other.y)
        override fun toString(): String = "($x, $y)"
    }

    data class Node(val pos: Pos, val prev: Node? = null) {
        override fun toString(): String = pos.toString() + if (prev != null) " <- $prev" else ""
    }

    val thieves: List<Pos> = grid.map { it.withIndex() }.withIndex()
        .flatMap { (y, v) -> v.filter { it.value == 1 }.map { (x) -> Pos(x, y) } }

    val target = Pos(grid.size - 1, grid.size - 1)

    val queue = java.util.PriorityQueue(
        Comparator.comparing<Node, Int> { (pos) -> grid[pos.y][pos.x] }
            .thenComparing { (pos) -> pos.manhattan(target) - thieves.minOf { it.manhattan(pos) } }
    )

    queue.add(Node(Pos(0, 0)))

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.pos == target) {
            println("Found: $current")
            return generateSequence(current) { it.prev }.minOf { (pos) -> thieves.minOf { it.manhattan(pos) } }
        }
        sequenceOf(
            current.pos.copy(y = current.pos.y + 1),
            current.pos.copy(x = current.pos.x + 1),
            current.pos.copy(x = current.pos.x - 1),
            current.pos.copy(y = current.pos.y - 1),
        ).filter { candidate ->
            candidate.x in grid.indices && candidate.y in grid.indices &&
                generateSequence(current) { it.prev }.none { it.pos == candidate }
        }.forEach { pos ->
            queue.add(Node(pos, current))
        }
    }
    return 0
}

import kotlin.math.abs
import kotlin.math.pow

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    data class Pos(val x: Int, val y: Int) {
        fun manhattan(other: Pos) = abs(x - other.x) + abs(y - other.y)
        fun euclideanSquared(other: Pos) = (x - other.x).toDouble().pow(2) + (y - other.y).toDouble().pow(2)
        override fun toString(): String = "($x, $y)"
    }

    data class Node(val pos: Pos, val prev: Node? = null) {
        override fun toString(): String = pos.toString() + if (prev != null) " <- $prev" else ""
    }

    val thieves: List<Pos> = grid.map { it.withIndex() }.withIndex()
        .flatMap { (y, v) -> v.filter { it.value == 1 }.map { (x) -> Pos(x, y) } }

    val target = Pos(grid.size - 1, grid.size - 1)

    val queue = java.util.PriorityQueue<Node>(
        Comparator.comparing { (pos) -> pos.euclideanSquared(target) - thieves.minOf { it.manhattan(pos) } })

    queue.add(Node(Pos(0, 0)))

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.pos == target) {
            return generateSequence(current) { it.prev }.minOf { (pos) -> thieves.minOf { it.manhattan(pos) } }
        }
        if (current.pos.x > 1) queue.add(Node(current.pos.copy(x = current.pos.x - 1), current))
        if (current.pos.x < target.x) queue.add(Node(current.pos.copy(x = current.pos.x + 1), current))
        if (current.pos.y > 1) queue.add(Node(current.pos.copy(y = current.pos.y - 1), current))
        if (current.pos.y < target.y) queue.add(Node(current.pos.copy(y = current.pos.y + 1), current))
    }
    return 0
}

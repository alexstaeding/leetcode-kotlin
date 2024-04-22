import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.min

fun openLock(deadends: Array<String>, target: String): Int {

    if (deadends.contains("0000")) {
        return -1
    }

    data class Pos(val a: Int, val b: Int, val c: Int, val d: Int) {
        constructor(value: String) : this(value[0].digitToInt(), value[1].digitToInt(), value[2].digitToInt(), value[3].digitToInt())

        private fun distance(a: Int, b: Int) = min(abs(a - b), 10 - abs(a - b)) * min(abs(a - b), 10 - abs(a - b))

        fun distanceTo(other: Pos): Int =
            distance(a, other.a) + distance(b, other.b) + distance(c, other.c) + distance(d, other.d)
    }

    class Node(val pos: Pos, val prev: Node? = null) {
        fun getDepth(): Int = generateSequence(prev) { it.prev }.count()
        operator fun contains(pos: Pos): Boolean = generateSequence(this) { it.prev }.any { it.pos == pos }
    }

    val startPos = Pos(0, 0, 0, 0)
    val targetPos = Pos(target)
    val deadendSet = deadends.map { Pos(it) }.toSet()

    val queue = PriorityQueue<Node> { a, b -> a.pos.distanceTo(targetPos).compareTo(b.pos.distanceTo(targetPos)) }

    queue.add(Node(startPos))

    val visited = mutableSetOf<Pos>()

    while (queue.isNotEmpty()) {
        val next = queue.poll()

        if (next.pos in visited) {
            continue
        }
        visited.add(next.pos)

        if (next.pos == targetPos) {
            return next.getDepth()
        }

        queue.addAll(
            sequenceOf(-1, 1).flatMap { delta ->
                sequenceOf(
                    next.pos.copy(a = ((next.pos.a + delta) % 10).takeIf { it >= 0 } ?: 9),
                    next.pos.copy(b = ((next.pos.b + delta) % 10).takeIf { it >= 0 } ?: 9),
                    next.pos.copy(c = ((next.pos.c + delta) % 10).takeIf { it >= 0 } ?: 9),
                    next.pos.copy(d = ((next.pos.d + delta) % 10).takeIf { it >= 0 } ?: 9)
                )
            }.filter { it !in deadendSet }
                .map { Node(it, next) }
        )
    }
    return -1
}

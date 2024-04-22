import java.util.PriorityQueue
import kotlin.math.absoluteValue

fun openLock(deadends: Array<String>, target: String): Int {
    data class Pos(val a: Int, val b: Int, val c: Int, val d: Int) {
        constructor(value: String) : this(value[0].digitToInt(), value[1].digitToInt(), value[2].digitToInt(), value[3].digitToInt())

        fun distanceTo(other: Pos): Int =
            (this.a - other.a).absoluteValue +
                (this.b - other.b).absoluteValue +
                (this.c - other.c).absoluteValue +
                (this.d - other.d).absoluteValue
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

    while (queue.isNotEmpty()) {
        val next = queue.poll()
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

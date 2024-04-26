import java.util.PriorityQueue

fun minFallingPathSum(grid: Array<IntArray>): Int {
    data class Node(val x: Int, val y: Int, val prev: Node? = null) {
        fun sum(): Int = generateSequence(this) { it.prev }.sumOf { grid[it.y][it.x] }
    }

    val queue = PriorityQueue<Node> { l, r -> l.sum().compareTo(r.sum()) }
    repeat(grid[0].size) { x -> queue.add(Node(x, 0)) }

    val solutions = mutableSetOf<Int>()

    while (queue.isNotEmpty()) {
        val current: Node = queue.poll()
        if (current.y == grid.size - 1) {
            solutions.add(current.sum())
            if (solutions.size == grid[0].size) {
                break
            }
            continue
        }
        repeat(grid[0].size) { x ->
            if (x != current.x) {
                queue.add(Node(x, current.y + 1, current))
            }
        }
    }
    return solutions.min()
}

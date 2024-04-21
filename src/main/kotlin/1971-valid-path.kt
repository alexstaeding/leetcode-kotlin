import java.util.ArrayDeque

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val lookup = Array(n) { mutableSetOf<Int>() }

    for ((a, b) in edges) {
        lookup[a].add(b)
        lookup[b].add(a)
    }

    val visited = HashSet<Int>(n)
    val queue = ArrayDeque<Int>()
    queue.add(source)

    while (queue.isNotEmpty()) {
        val next = queue.pop()
        if (next in visited) continue
        if (next == destination) return true
        visited.add(next)
        queue.addAll(lookup[next])
    }

    return false
}

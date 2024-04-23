fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) {
        return listOf(0)
    }

    class Node(val id: Int, val depth: Int = 0)

    val lookup = Array(n) { mutableSetOf<Int>() }

    for ((a, b) in edges) {
        lookup[a].add(b)
        lookup[b].add(a)
    }

    // prev, node -> min height
    val cache = HashMap<Pair<Int, Int>, Int>(n)

    fun Node.getDepth(next: Int): Int = cache.getOrPut(id to next) {
        1 + (lookup[next].filter { it != id }.maxOfOrNull { Node(next, depth + 1).getDepth(it) } ?: 0)
    }

    fun Node.getDepth(): Int = lookup[id].maxOf { getDepth(it) } + 1

    var minTreeSize = n
    val roots = mutableListOf<Int>()

    for (id in 0..<n) {
        val depth = Node(id).getDepth()
        if (depth < minTreeSize) {
            minTreeSize = depth
            roots.clear()
            roots.add(id)
        } else if (depth == minTreeSize) {
            roots.add(id)
        }
    }

    println("Cache:")
    for ((k, v) in cache) {
        println("$k -> $v")
    }

    return roots
}

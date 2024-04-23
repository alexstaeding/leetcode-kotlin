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

    data class Arguments(val prev: Node, val next: Int)

    var outerCalls = 0
    var innerCalls = 0

    val getDepth = DeepRecursiveFunction<Arguments, Int> { (prev, next) ->
        outerCalls++
        cache.getOrPut(prev.id to next) {
            innerCalls++
            1 + (lookup[next].filter { it != prev.id }.maxOfOrNull { callRecursive(Arguments(Node(next, prev.depth + 1), it)) } ?: 0)
        }
    }

    fun Node.getDepth(): Int = lookup[id].maxOf { getDepth(Arguments(this, it)) } + 1

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

    println("nodes = $n, outerCalls = $outerCalls, innerCalls = $innerCalls, cacheSize = ${cache.size}")

    return roots
}

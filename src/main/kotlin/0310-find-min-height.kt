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
    class CacheKey(val prev: Int, val next: Int) {
        override fun hashCode(): Int = prev shl 16 or next
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is CacheKey) return false
            return prev == other.prev && next == other.next
        }
    }
    val cache = HashMap<CacheKey, Int>(n*2)

    data class Arguments(val prev: Node, val next: Int)

    var outerCalls = 0
    var innerCalls = 0

    val getDepth = DeepRecursiveFunction<Arguments, Int> { (prev, next) ->
        println(" ".repeat(prev.depth) + "> Entering getDepth(${prev.id}, $next)")
        outerCalls++
        cache.getOrPut(CacheKey(prev.id, next)) {
            println(" ".repeat(prev.depth) + "> calculating(${prev.id}, $next)")
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

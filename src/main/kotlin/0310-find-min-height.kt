fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) {
        return listOf(0)
    }

    val lookup = Array(n) { mutableSetOf<Int>() }

    for ((a, b) in edges) {
        lookup[a].add(b)
        lookup[b].add(a)
    }

    data class Arguments(val prev: Int, val next: Int) {
        override fun hashCode(): Int = prev shl 16 or next
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Arguments) return false
            return prev == other.prev && next == other.next
        }
    }

    // prev, node -> min height
    val cache = HashMap<Arguments, Int>(n*2)

    val getDepth = DeepRecursiveFunction<Arguments, Int> { args ->
        cache.getOrPut(args) {
            1 + (lookup[args.next].filter { it != args.prev }.maxOfOrNull { callRecursive(Arguments(args.next, it)) } ?: 0)
        }
    }

    fun getDepth(id: Int): Int = lookup[id].maxOf { getDepth(Arguments(id, it)) } + 1

    var minTreeSize = n
    val roots = mutableListOf<Int>()

    for (id in 0..<n) {
        val depth = getDepth(id)
        if (depth < minTreeSize) {
            minTreeSize = depth
            roots.clear()
            roots.add(id)
        } else if (depth == minTreeSize) {
            roots.add(id)
        }
    }

    return roots
}

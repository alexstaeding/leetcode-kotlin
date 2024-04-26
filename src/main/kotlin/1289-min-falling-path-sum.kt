import java.util.PriorityQueue

fun minFallingPathSum(grid: Array<IntArray>): Int {
    var lastBest = PriorityQueue<IndexedValue<Int>> { (_, l), (_, r) -> l.compareTo(r) }
    grid[0].withIndex().forEach { lastBest.add(it) }
    grid.asSequence().drop(1).forEach { row ->
        lastBest = row.withIndex().mapTo(PriorityQueue<IndexedValue<Int>> { (_, l), (_, r) -> l.compareTo(r) }) { (index, value) ->
            IndexedValue(index, value + lastBest.asSequence().filter { (lastIndex) -> index != lastIndex }.minOf { (_, v) -> v })
        }
    }
    return lastBest.minOf { (_, v) -> v }
}

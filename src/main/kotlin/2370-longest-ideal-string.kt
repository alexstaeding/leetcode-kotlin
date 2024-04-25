import kotlin.math.max
import kotlin.math.min

fun longestIdealString(s: String, k: Int): Int {
    val ideal = MutableList(size = 26) { 0 }
    for (c in s) {
        val n = c - 'a'
        ideal[n] = ideal.slice(max(n - k, 0)..min(n + k, 25)).max() + 1
    }
    return ideal.max()
}

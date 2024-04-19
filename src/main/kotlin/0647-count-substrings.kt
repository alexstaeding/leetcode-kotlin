fun countSubstrings(
    s: String,
    start: Int,
    end: Int,
): Set<Pair<Int, Int>> {
    if (start == end) {
        return setOf(start to end)
    }
    val len = end - start + 1
    val half = len / 2
    val self = if ((0..<half).all {
            s[start + it] == s[end - it]
        }) setOf(start to end) else setOf()
    return self +
        countSubstrings(s, start + 1, end) +
        countSubstrings(s, start, end - 1)
}

fun countSubstrings(s: String): Int = countSubstrings(s, 0, s.length - 1).size

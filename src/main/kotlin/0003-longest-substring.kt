private fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    val set = mutableSetOf<Char>()
    var low = 0
    var maxDiff = 0
    for ((index, char) in s.withIndex()) {
        while (set.contains(char)) {
            val toRemove = s[low++]
            if (toRemove == char) {
                break
            }
            set.remove(toRemove)
        }
        set.add(char)
        if (index - low > maxDiff) {
            maxDiff = index - low
        }
    }
    return maxDiff + 1
}

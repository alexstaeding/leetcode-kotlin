val map = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
)

fun romanToInt(s: String): Int {
    var total = map[s[0]] ?: return 0
    var i = 0
    for (i in 1..<s.length) {
        val v0 = map[s[i - 1]]!!
        val v1 = map[s[i]]!!
        total += if (v0 < v1) {
            v1 - 2 * v0
        } else {
            v1
        }
    }

    return total
}

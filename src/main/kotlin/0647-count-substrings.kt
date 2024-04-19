fun countSubstrings(s: String): Int {
    return s.indices.sumOf { i ->
        var radius = 0
        while (true) {
            if (i - radius >= 0 && i + radius < s.length &&
                s[i - radius] == s[i + radius]) {
                radius++
            } else {
                break
            }
        }
        radius
    } + s.indices.sumOf { i ->
        var radius = 0
        while (true) {
            if (i - radius >= 0 && i + 1 + radius < s.length &&
                s[i - radius] == s[i + 1 + radius]) {
                radius++
            } else {
                break
            }
        }
        radius
    }
}

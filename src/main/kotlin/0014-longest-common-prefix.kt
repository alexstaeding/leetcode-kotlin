fun longestCommonPrefix(strings: Array<String>): String {
    val sb = StringBuilder()
    outer@ for (c in strings[0]) {
        for (i in 1..<strings.size) {
            if (strings[i].getOrNull(sb.length) != c) {
                break@outer
            }
        }
        sb.append(c)
    }
    return sb.toString()
}

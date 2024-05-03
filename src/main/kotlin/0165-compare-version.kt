val regex = "(?<=[.])?\\d+(?=[.])?".toRegex()

fun compareVersion(version1: String, version2: String): Int {
    (regex.findAll(version1).map { it.value.toInt() } + generateSequence { -1 })
        .zip(regex.findAll(version2).map { it.value.toInt() } + generateSequence { -1 })
        .forEach { (l, r) ->
            if (l in 0..<r) {
                return -1
            } else if (r in 0..<l) {
                return 1
            } else if (-1 == l) {
                return 0
            }
        }
    return 0
}

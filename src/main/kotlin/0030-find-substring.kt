class PartialResult(
    val start: Int,
    startWord: String,
    private val toFind: Int,
    private val charWordMap: Map<Char, List<String>>,
    private val wordCountMap: Map<String, Int>,
) {
    private var currentWord = startWord
    private var pos = start
    private val ownWords = wordCountMap.toMutableMap()
        .also { it.compute(startWord) { _, v -> v!! - 1 } }
    var valid = false

    fun checkValid(): Boolean {
        if (valid) return true
        if (++pos - start == toFind) {
            valid = true
            return true
        }
        return false
    }

    /**
     * Whether I should keep on living
     */
    fun inc(c: Char, newResults: MutableList<PartialResult>): Boolean {
        if (valid) {
            return true
        }
        if (checkValid()) return true
        if ((pos - start) % currentWord.length == 0) {
            var continued = 0
            for (candidate in charWordMap[c] ?: return false) {
                if (ownWords.compute(candidate) { _, v -> (v ?: 0) - 1 }!! >= 0) {
                    if (continued++ == 0) {
                        currentWord = candidate
                    } else {
                        newResults.add(PartialResult(pos, candidate, toFind, charWordMap, wordCountMap))
                    }
                }
            }
            if (continued == 0) {
                return false
            }
        } else {
            // check that the current word keeps matching
            val check = currentWord[(pos - start) % currentWord.length]
            if (check != c) {
                // die
                return false
            }
        }
        return true
    }
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val len = words[0].length
    if (len * words.size > s.length) return emptyList()
    val wordMap = words.groupBy { it[0] }.mapValues { (_, v) -> v.distinct() }
    val wordCountMap = words.groupingBy { it }.eachCount()
    val results = mutableListOf<PartialResult>()
    for (i in s.indices) {
        val newResults = mutableListOf<PartialResult>()
        val removeResults = mutableSetOf<PartialResult>()
        for (r in results) {
            if (!r.inc(s[i], newResults)) {
                removeResults.add(r)
            }
        }
        results += newResults
        results -= removeResults

        // get all words that start with this letter
        wordMap[s[i]]?.forEach { results += PartialResult(i, it, len * words.size, wordMap, wordCountMap) }
    }
    return results.onEach { it.checkValid() }.filter { it.valid }.map { it.start }.distinct()
}

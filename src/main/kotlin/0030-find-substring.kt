class PartialResult(
    val start: Int,
    private var pos: Int,
    startWord: String,
    private val toFind: Int,
    private val charWordMap: Map<Char, List<String>>,
    wordCountMap: MutableMap<String, Int>,
    copyWordCountMap: Boolean = true,
) {
    private var currentWord = startWord
    private val ownWords = if (copyWordCountMap) {
        wordCountMap.toMutableMap()
            .also { it.compute(startWord) { _, v -> v!! - 1 } }
    } else {
        wordCountMap
    }
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
            var continued: String? = null
            for (candidate in charWordMap[c] ?: return false) {
                val candidateCount = ownWords[candidate] ?: 0
                if (candidateCount > 0) {
                    if (continued == null) {
                        ownWords[candidate] = candidateCount - 1
                        currentWord = candidate
                        continued = candidate
                    } else {
                        val splitWords = ownWords.toMutableMap()
                        splitWords.compute(continued) { _, v -> v!! + 1}
                        splitWords.compute(candidate) { _, v -> v!! - 1}
                        newResults.add(PartialResult(start, pos, candidate, toFind, charWordMap, splitWords, copyWordCountMap = false))
                    }
                }
            }
            if (continued == null) {
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
        wordMap[s[i]]?.forEach { results += PartialResult(i, i, it, len * words.size, wordMap, wordCountMap.toMutableMap()) }
    }
    return results.onEach { it.checkValid() }.filter { it.valid }.map { it.start }.distinct()
}

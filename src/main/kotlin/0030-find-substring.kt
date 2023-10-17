typealias OrderedWord = IndexedValue<String>

class PartialResult(
    val start: Int,
    startWord: OrderedWord,
    private val toFind: Int,
    private val wordMap: Map<Char, List<OrderedWord>>,
) {
    private var currentWord = startWord
    private var pos = start
    private val resultWords = linkedSetOf(startWord)
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
        if (pos - start == resultWords.size * currentWord.value.length) {
            val nextWords = wordMap[c]?.filter { it !in resultWords }
            if (nextWords.isNullOrEmpty()) {
                // die
                return false
            }
            currentWord = nextWords[0]
            resultWords += currentWord
            if (nextWords.size > 1) {
                // split
                for (i in 1..<nextWords.size) {
                    newResults.add(PartialResult(pos, nextWords[i], toFind, wordMap))
                }
            }
        } else {
            // check that the current word keeps matching
            val check = currentWord.value[(pos - start) % currentWord.value.length]
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
    val wordMap = words.withIndex().groupBy { it.value[0] }
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
        wordMap[s[i]]?.forEach { results += PartialResult(i, it, len * words.size, wordMap) }
    }
    return results.onEach { it.checkValid() }.filter { it.valid }.map { it.start }.distinct()
}

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

    init {
        println("Starting partial result at position $start with word '$startWord'")
    }

    override fun toString(): String {
        return "$start:$pos toFind: $toFind currentWord: $currentWord words: ${resultWords.map { (i, v) -> "$v[$i]" }}"
    }

    fun checkValid(): Boolean {
        if (valid) return true
        if (++pos - start == toFind) {
            println("Graduated $this")
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
        println("Inc $this")
        if (checkValid()) return true
        if (pos - start == resultWords.size * currentWord.value.length) {
            val nextWords = wordMap[c]?.filter { it !in resultWords }
            if (nextWords.isNullOrEmpty()) {
                // die
                println("No future for $this")
                return false
            }
            currentWord = nextWords[0]
            resultWords += currentWord
            if (nextWords.size > 1) {
                // split
                for (i in 1..<nextWords.size) {
                    println("Splitting $this for ${nextWords[i]}")
                    newResults.add(PartialResult(pos, nextWords[i], toFind, wordMap))
                }
            }
        } else {
            // check that the current word keeps matching
            val check = currentWord.value[(pos - start) % currentWord.value.length]
            println("Checking ${(pos - start) % currentWord.value.length} ($check) == $c)")
            if (check != c) {
                // die
                println("No match for $this")
                return false
            }
        }
        println("Life goes on for $this")
        return true
    }
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    println("Searching $s")
    val len = words[0].length
    if (len * words.size > s.length) return emptyList()
    val wordMap = words.asSequence()
        .withIndex()
        .groupBy { it.value[0] }
    val results = mutableListOf<PartialResult>()
    for (i in s.indices) {
        val newResults = mutableListOf<PartialResult>()
        println("==== ${s[i]}[$i]")
        results.filterNot { it.inc(s[i], newResults) }
            .forEach { results.remove(it) }
        results += newResults
        // get all words that start with this letter
        wordMap[s[i]]?.forEach { results += PartialResult(i, it, len * words.size, wordMap) }
    }
    return results.onEach { it.checkValid() }.filter { it.valid }.map { it.start }.distinct()
}

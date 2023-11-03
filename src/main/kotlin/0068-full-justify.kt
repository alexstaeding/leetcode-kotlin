fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    // first pick which words go on which line
    val lines: MutableList<MutableList<String>> = mutableListOf()
    var width = 0
    for (word in words) {
        if (width + word.length >= maxWidth) {
            width = word.length
            lines.add(mutableListOf(word))
        } else {
            width += word.length + 1
            if (lines.isEmpty()) {
                lines.add(mutableListOf(word))
            } else {
                lines.last().add(word)
            }
        }
    }
    return lines.withIndex().map { (index, line) ->
        val spacesToFill = maxWidth - line.sumOf { it.length }
        if (line.size == 1) {
            return@map line[0] + " ".repeat(spacesToFill)
        }
        if (index == lines.size - 1) {
            return@map line.joinToString(" ") + " ".repeat(spacesToFill - (line.size - 1))
        }
        val gaps = line.size - 1
        val eachGapSpace = spacesToFill / gaps
        val gapsWithExtraSpace = spacesToFill % gaps
        buildString(maxWidth) {
            for ((i, word) in line.withIndex()) {
                append(word)
                if (i == line.size - 1) {
                    break
                }
                for (j in 0..<eachGapSpace) {
                    append(' ')
                }
                if (i < gapsWithExtraSpace) {
                    append(' ')
                }
            }
        }
    }
}

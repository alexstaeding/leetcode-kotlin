fun reversePrefix(word: String, ch: Char): String {
    val index = word.indexOf(ch)
    return if (index > 0) {
        word.substring(0..index).reversed() + word.substring(index + 1)
    } else word
}

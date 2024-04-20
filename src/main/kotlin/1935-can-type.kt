fun canBeTypedWords(text: String, brokenLetters: String): Int {
    return text.split(" ").count { word -> word.none { letter -> letter in brokenLetters } }
}

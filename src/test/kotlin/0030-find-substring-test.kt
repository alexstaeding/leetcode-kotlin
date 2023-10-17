import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindSubstringTest : FunSpec({
    test("barfoothefoobarman = [0, 9]") {
        findSubstring(
            "barfoothefoobarman",
            arrayOf("foo", "bar")
        ).sorted() shouldBe listOf(0, 9)
    }
    test("wordgoodgoodgoodbestword = []") {
        findSubstring(
            "wordgoodgoodgoodbestword",
            arrayOf("word", "good", "best", "word")
        ).sorted() shouldBe listOf()
    }
    test("barfoofoobarthefoobarman = [6, 9, 12]") {
        findSubstring(
            "barfoofoobarthefoobarman",
            arrayOf("bar", "foo", "the")
        ).sorted() shouldBe listOf(6, 9, 12)
    }
    test("wordgoodgoodgoodbestword = [8]") {
        findSubstring(
            "wordgoodgoodgoodbestword",
            arrayOf("word", "good", "best", "good")
        ).sorted() shouldBe listOf(8)
    }
    test("bcabbcaabbccacacbabccacaababcbb = [6, 16, 17, 18, 19, 20]") {
        findSubstring(
            "bcabbcaabbccacacbabccacaababcbb",
            arrayOf("c", "b", "a", "c", "a", "a", "a", "b", "c")
        ).sorted() shouldBe listOf(6, 16, 17, 18, 19, 20)
    }
    test("bccbcc = [0]") {
        findSubstring(
            "bccbcc",
            arrayOf("bc", "cc", "cb")
        ).sorted() shouldBe listOf(0)
    }
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindSubstringTest : FunSpec({
    test("basics tests") {
        findSubstring(
            "barfoothefoobarman",
            arrayOf("foo", "bar")
        ).sorted() shouldBe listOf(0, 9)
        findSubstring(
            "wordgoodgoodgoodbestword",
            arrayOf("word", "good", "best", "word")
        ).sorted() shouldBe listOf()
        findSubstring(
            "barfoofoobarthefoobarman",
            arrayOf("bar", "foo", "the")
        ).sorted() shouldBe listOf(6, 9, 12)
    }
})

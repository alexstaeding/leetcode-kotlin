import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FullJustifyTest : FunSpec({
    test("words = [\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"], maxWidth = 16") {
        fullJustify(
            arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            16
        ) shouldBe listOf(
            "This    is    an",
            "example  of text",
            "justification.  "
        )
    }
    test("words = [\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"], maxWidth = 16") {
        fullJustify(
            arrayOf("What", "must", "be", "acknowledgment", "shall", "be"),
            16
        ) shouldBe listOf(
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
        )
    }
    test("words = [\"Science\",\"is\",\"what\",\"we\",\"understand\",\"well\",\"enough\",\"to\",\"explain\",\"to\",\"a\",\"computer.\",\"Art\",\"is\",\"everything\",\"else\",\"we\",\"do\"], maxWidth = 20") {
        fullJustify(
            arrayOf(
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.",
                "Art", "is", "everything", "else", "we", "do"
            ),
            20
        ) shouldBe listOf(
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
        )
    }
})

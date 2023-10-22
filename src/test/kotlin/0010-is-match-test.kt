import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class IsMatchTest : FunSpec({
    test("s = \"aa\", p = \"a\" -> false") {
        isMatch("aa", "a") shouldBe false
    }
    test("s = \"aa\", p = \"a*\" -> true") {
        isMatch("aa", "a*") shouldBe true
    }
    test("s = \"ab\", p = \".*\" -> true") {
        isMatch("ab", ".*") shouldBe true
    }
})

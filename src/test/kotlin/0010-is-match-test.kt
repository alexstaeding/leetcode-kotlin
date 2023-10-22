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
    test("s = \"aab\", p = \"c*a*b\" -> true") {
        isMatch("aab", "c*a*b") shouldBe true
    }
    test("s = \"mississippi\", p = \"mis*is*p*.\" -> false") {
        isMatch("mississippi", "mis*is*p*.") shouldBe false
    }
    test("s = \"ab\", p = \".*c\" -> false") {
        isMatch("ab", ".*c") shouldBe false
    }
})

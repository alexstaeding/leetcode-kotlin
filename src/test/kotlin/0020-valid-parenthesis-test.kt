import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ValidParenthesisTest : FunSpec({
    test("() -> true") {
        isValidParenthesis("()") shouldBe true
    }
    test("()[]{} -> true") {
        isValidParenthesis("()[]{}") shouldBe true
    }
    test("(] -> false") {
        isValidParenthesis("(]") shouldBe false
    }
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LongestIdealStringTest : FunSpec({
    test("longestIdealString(\"acfgbd\", 2)") {
        longestIdealString("acfgbd", 2) shouldBe 4
    }
    test("longestIdealString(\"abcd\", 3)") {
        longestIdealString("acfgbd", 2) shouldBe 4
    }
})

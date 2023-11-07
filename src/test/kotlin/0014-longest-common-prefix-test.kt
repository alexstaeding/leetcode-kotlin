import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LongestCommonPrefixTest : FunSpec({
    test("strings = [flower, flow, flight] -> \"fl\"") {
        longestCommonPrefix(arrayOf("flower", "flow", "flight")) shouldBe "fl"
    }
    test("string = [dog, racecar, car] -> \"\"") {
        longestCommonPrefix(arrayOf("dog", "racecar", "car")) shouldBe ""
    }
})

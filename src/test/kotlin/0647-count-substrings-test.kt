import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CountSubstringsTest : FunSpec({
    test("countSubstrings(\"abc\") == 3") {
        countSubstrings("abc") shouldBe 3
    }
    test("countSubstrings(\"aaa\") == 6") {
        countSubstrings("aaa") shouldBe 6
    }
    test("countSubstrings(\"abba\") == 6") {
        countSubstrings("abba") shouldBe 6
    }
    test("countSubstrings(\"xkjkqlajprjwefilxgpdpebieswu\") == 30") {
        countSubstrings("xkjkqlajprjwefilxgpdpebieswu") shouldBe 30
    }
})

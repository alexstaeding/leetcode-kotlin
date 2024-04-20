import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CanTypeTest : FunSpec({
    // leetcode 1935
    test("canBeTypedWords(\"hello world\", \"ad\") should return 1") {
        canBeTypedWords("hello world", "ad") shouldBe 1
    }

    test("canBeTypedWords(\"leet code\", \"lt\") should return 1") {
        canBeTypedWords("leet code", "lt") shouldBe 1
    }

    test("canBeTypedWords(\"leet code\", \"e\") should return 0") {
        canBeTypedWords("leet code", "e") shouldBe 0
    }
})

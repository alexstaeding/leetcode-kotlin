import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ReversePrefixTest : FunSpec({
    test("reversePrefix(\"abcdef\", 'd')") {
        reversePrefix("abcdef", 'd') shouldBe "dcbaef"
    }
    test("reversePrefix(\"xyxzxe\", 'z')") {
        reversePrefix("xyxzxe", 'z') shouldBe "zxyxxe"
    }
    test("reversePrefix(\"abcd\", 'z')") {
        reversePrefix("abcd", 'z') shouldBe "abcd"
    }
    test("reversePrefix(\"abcdef\", 'a')") {
        reversePrefix("abcdef", 'a') shouldBe "abcdef"
    }
})

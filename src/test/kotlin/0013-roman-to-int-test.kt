import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RomanToIntTest : FunSpec({
    test("I should be 1") {
        romanToInt("I") shouldBe 1
    }
    test("IV should be 4") {
        romanToInt("IV") shouldBe 4
    }
    test("V should be 5") {
        romanToInt("V") shouldBe 5
    }
    test("IX should be 9") {
        romanToInt("IX") shouldBe 9
    }
    test("X should be 10") {
        romanToInt("X") shouldBe 10
    }
    test("XL should be 40") {
        romanToInt("XL") shouldBe 40
    }
    test("L should be 50") {
        romanToInt("L") shouldBe 50
    }
    test("XC should be 90") {
        romanToInt("XC") shouldBe 90
    }
    test("C should be 100") {
        romanToInt("C") shouldBe 100
    }
    test("CD should be 400") {
        romanToInt("CD") shouldBe 400
    }
    test("D should be 500") {
        romanToInt("D") shouldBe 500
    }
    test("CM should be 900") {
        romanToInt("CM") shouldBe 900
    }
    test("M should be 1000") {
        romanToInt("M") shouldBe 1000
    }
    test("MMMCMXCIV should be 3994") {
        romanToInt("MMMCMXCIV") shouldBe 3994
    }
})

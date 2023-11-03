import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ClimbStairsTest : FunSpec({
    test("n = 1 -> 1") {
        climbStairs(1) shouldBe 1
    }
    test("n = 2 -> 2") {
        climbStairs(2) shouldBe 2
    }
    test("n = 3 -> 3") {
        climbStairs(3) shouldBe 3
    }
    test("n = 4 -> 5") {
        climbStairs(4) shouldBe 5
    }
    test("n = 5 -> 8") {
        climbStairs(5) shouldBe 8
    }
    test("n = 35") {
        climbStairs(35) shouldBe 14930352
    }
})

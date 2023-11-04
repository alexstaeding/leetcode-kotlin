import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PlusOneTest : FunSpec({
    test("digits = [1,2,3] -> [1,2,4]") {
        plusOne(intArrayOf(1, 2, 3)) shouldBe intArrayOf(1, 2, 4)
    }
    test("digits = [4,3,2,1] -> [4,3,2,2]") {
        plusOne(intArrayOf(4, 3, 2, 1)) shouldBe intArrayOf(4, 3, 2, 2)
    }
    test("digits = [0] -> [1]") {
        plusOne(intArrayOf(0)) shouldBe intArrayOf(1)
    }
    test("digits = [9, 9] -> [1, 0, 0]") {
        plusOne(intArrayOf(9, 9)) shouldBe intArrayOf(1, 0, 0)
    }
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TwoSumTest : FunSpec({
    test("basics tests") {
        twoSum(intArrayOf(2, 7, 11, 15), 9).sorted() shouldBe intArrayOf(0, 1).sorted()
        twoSum(intArrayOf(3, 2, 4), 6).sorted() shouldBe intArrayOf(1, 2).sorted()
        twoSum(intArrayOf(3, 3), 6).sorted() shouldBe intArrayOf(0, 1).sorted()
    }
})

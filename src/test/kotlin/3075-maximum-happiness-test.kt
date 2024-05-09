import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MaximumHappinessTest : FunSpec({
    test("maximumHappinessSum([1, 2, 3], 2)") {
        maximumHappinessSum(intArrayOf(1, 2, 3), 2) shouldBe 4
    }
    test("maximumHappinessSum([1, 1, 1, 1], 2)") {
        maximumHappinessSum(intArrayOf(1, 1, 1, 1), 2) shouldBe 1
    }
    test("maximumHappinessSum([2, 3, 4, 5], 1)") {
        maximumHappinessSum(intArrayOf(2, 3, 4, 5), 1) shouldBe 5
    }
})

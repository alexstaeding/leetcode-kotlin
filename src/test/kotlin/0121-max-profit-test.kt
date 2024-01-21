import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MaxProfitTest : FunSpec({
    test("prices = [7,1,5,3,6,4] -> 5") {
        maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) shouldBe 5
    }
    test("prices = [7,6,4,3,1] -> 0") {
        maxProfit(intArrayOf(7, 6, 4, 3, 1)) shouldBe 0
    }
    test("prices = [1,2] -> 1") {
        maxProfit(intArrayOf(1, 2)) shouldBe 1
    }
    test("prices = [2,1] -> 0") {
        maxProfit(intArrayOf(2, 1)) shouldBe 0
    }
})

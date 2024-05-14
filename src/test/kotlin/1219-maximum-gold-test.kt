import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MaximumGoldTest : FunSpec({
    test("testMaximumGold") {
        getMaximumGold(arrayOf(
            intArrayOf(0, 6, 0),
            intArrayOf(5, 8, 7),
            intArrayOf(0, 9, 0)
        )) shouldBe 24
        getMaximumGold(arrayOf(
            intArrayOf(1, 0, 7),
            intArrayOf(2, 0, 6),
            intArrayOf(3, 4, 5),
            intArrayOf(0, 3, 0),
            intArrayOf(9, 0, 20)
        )) shouldBe 28
    }
})

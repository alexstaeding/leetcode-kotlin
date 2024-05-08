import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindRelativeRanksTest : FunSpec({
    test("testFindRelativeRanks([5, 4, 3, 2, 1])") {
        findRelativeRanks(intArrayOf(5, 4, 3, 2, 1)) shouldBe arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5")
    }
    test("testFindRelativeRanks([10, 3, 8, 9, 4])") {
        findRelativeRanks(intArrayOf(10, 3, 8, 9, 4)) shouldBe arrayOf("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4")
    }
})

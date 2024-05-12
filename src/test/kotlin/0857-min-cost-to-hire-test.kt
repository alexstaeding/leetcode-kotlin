import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MinCostToHireTest : FunSpec({
    test("minCostToHireWorkers([10, 20, 5], [70, 50, 30], 2)") {
        mincostToHireWorkers(intArrayOf(10, 20, 5), intArrayOf(70, 50, 30), 2) shouldBe 105.0
    }
    test("minCostToHireWorkers([3, 1, 10, 10, 1], [4, 8, 2, 2, 7], 3)") {
        mincostToHireWorkers(intArrayOf(3, 1, 10, 10, 1), intArrayOf(4, 8, 2, 2, 7), 3) shouldBe 30.666666666666668
    }
    test("minCostToHireWorkers([3, 1, 10, 10, 1], [4, 8, 2, 2, 7], 4)") {
        mincostToHireWorkers(intArrayOf(3, 1, 10, 10, 1), intArrayOf(4, 8, 2, 2, 7), 4) shouldBe 25.0
    }
    test("minCostToHireWorkers([3, 1, 10, 10, 1], [4, 8, 2, 2, 7], 5)") {
        mincostToHireWorkers(intArrayOf(3, 1, 10, 10, 1), intArrayOf(4, 8, 2, 2, 7), 5) shouldBe 24.0
    }
    test("minCostToHireWorkers([3, 1, 10, 10, 1], [4, 8, 2, 2, 7], 1)") {
        mincostToHireWorkers(intArrayOf(3, 1, 10, 10, 1), intArrayOf(4, 8, 2, 2, 7), 1) shouldBe 4.0
    }
})

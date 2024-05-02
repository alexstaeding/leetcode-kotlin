import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindMaxKTest : FunSpec({
    test("findMaxK([-1, 2, -3, 3])") {
        findMaxK(intArrayOf(-1, 2, -3, 3)) shouldBe 3
    }
    test("findMaxK([-1,10,6,7,-7,1])") {
        findMaxK(intArrayOf(-1, 10, 6, 7, -7, 1)) shouldBe 7
    }
    test("findMaxK([-10,8,6,7,-2,-3])") {
        findMaxK(intArrayOf(-10, 8, 6, 7, -2, -3)) shouldBe -1
    }
})

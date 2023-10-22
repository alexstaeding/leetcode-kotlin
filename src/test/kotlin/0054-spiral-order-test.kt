import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SpiralOrderTest : FunSpec({
    test("[[1,2,3],[4,5,6],[7,8,9]] = [1,2,3,6,9,8,7,4,5]") {
        spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        ) shouldBe listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)
    }
    test("[[1,2,3,4],[5,6,7,8],[9,10,11,12]] = [1,2,3,4,8,12,11,10,9,5,6,7]") {
        spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
            )
        ) shouldBe listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
    }
})

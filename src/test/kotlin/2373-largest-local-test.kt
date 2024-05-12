import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LargestLocalTest : FunSpec({
    test("largestLocal([[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]])") {
        val grid = arrayOf(
            intArrayOf(9, 9, 8, 1),
            intArrayOf(5, 6, 2, 6),
            intArrayOf(8, 2, 6, 4),
            intArrayOf(6, 2, 2, 2)
        )
        val expected = arrayOf(
            intArrayOf(9, 9),
            intArrayOf(8, 6),
        )
        largestLocal(grid) shouldBe expected
    }
    test("largestLocal([[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]])") {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 2, 1, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 2),
        )
        largestLocal(grid) shouldBe expected
    }
})

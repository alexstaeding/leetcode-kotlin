import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MinFallingPathSumTest : FunSpec({
    test("minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])") {
        minFallingPathSum(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        ) shouldBe 13
    }
})

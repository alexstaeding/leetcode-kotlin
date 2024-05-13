import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MatrixScoreTest : FunSpec({
    test("matrixScore([[0,0,1,1],[1,0,1,0],[1,1,0,0]])") {
        val grid = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
        )
        matrixScore(grid) shouldBe 39
    }
    test("matrixScore([[0]])") {
        val grid = arrayOf(
            intArrayOf(0)
        )
        matrixScore(grid) shouldBe 1
    }
})

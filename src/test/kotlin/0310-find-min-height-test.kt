import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindMinHeightTest : FunSpec({
    test("findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]])") {
        findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))) shouldBe listOf(1)
    }

    test("findMinHeightTrees(6, [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]])") {
        findMinHeightTrees(6, arrayOf(intArrayOf(3, 0), intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 4), intArrayOf(5, 4))) shouldBe listOf(3, 4)
    }
})

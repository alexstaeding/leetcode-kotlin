import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindMinHeightTest : FunSpec({
    test("findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]])") {
        findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))) shouldBe listOf(1)
    }

    test("findMinHeightTrees(6, [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]])") {
        findMinHeightTrees(6, arrayOf(intArrayOf(3, 0), intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 4), intArrayOf(5, 4))) shouldBe listOf(3, 4)
    }

    test("findMinHeightTrees(1, [])") {
        findMinHeightTrees(1, emptyArray()) shouldBe listOf(0)
    }

    test("findMinHeightTrees(10, Array(9) { intArrayOf(it, it + 1) })") {
        findMinHeightTrees(10, Array(9) { intArrayOf(it, it + 1) }) shouldBe listOf(4, 5)
    }

    // huge
    test("findMinHeightTrees(10000, Array(9999) { intArrayOf(it, it + 1) })") {
        findMinHeightTrees(10000, Array(9999) { intArrayOf(it, it + 1) }) shouldBe listOf(4999, 5000)
    }

    // more huger
    test("findMinHeightTrees(100000, Array(99999) { intArrayOf(it, it + 1) })") {
        findMinHeightTrees(100000, Array(99999) { intArrayOf(it, it + 1) }) shouldBe listOf(49999, 50000)
    }

})

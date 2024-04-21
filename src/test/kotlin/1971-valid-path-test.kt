import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ValidPathTest : FunSpec({
    test("validPath(3, [[0,1], [1,2], [2,0]], 0, 2) should return true") {
        validPath(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0)), 0, 2) shouldBe true
    }

    test("validPath(6, [[0,1], [0,2], [3,5], [5,4], [4,3]], 0, 5) should return false") {
        validPath(6, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(3, 5), intArrayOf(5, 4), intArrayOf(4, 3)), 0, 5) shouldBe false
    }

    test("validPath(1, [], 0, 0) should return true") {
        validPath(1, arrayOf(), 0, 0) shouldBe true
    }

    test("validPath(10, [[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]], 7, 5) should return true") {
        validPath(
            10,
            arrayOf(
                intArrayOf(0, 7),
                intArrayOf(0, 8),
                intArrayOf(6, 1),
                intArrayOf(2, 0),
                intArrayOf(0, 4),
                intArrayOf(5, 8),
                intArrayOf(4, 7),
                intArrayOf(1, 3),
                intArrayOf(3, 5),
                intArrayOf(6, 5)
            ),
            7,
            5
        ) shouldBe true
    }
})

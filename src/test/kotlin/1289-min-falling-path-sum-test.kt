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
    test("minFallingPathSum([[-37,51,-36,34,-22],[82,4,30,14,38],[-68,-52,-92,65,-85],[-49,-3,-77,8,-19],[-60,-71,-21,-62,-73]])") {
        minFallingPathSum(
            arrayOf(
                intArrayOf(-37, 51, -36, 34, -22),
                intArrayOf(82, 4, 30, 14, 38),
                intArrayOf(-68, -52, -92, 65, -85),
                intArrayOf(-49, -3, -77, 8, -19),
                intArrayOf(-60, -71, -21, -62, -73),
            )
        ) shouldBe -268
    }
})

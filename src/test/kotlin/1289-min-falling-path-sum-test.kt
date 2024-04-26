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
    test("minFallingPathSum([...huge...]") {
        minFallingPathSum(
            arrayOf(
                intArrayOf(-2, -18, 31, -10, -71, 82, 47, 56, -14, 42),
                intArrayOf(-95, 3, 65, -7, 64, 75, -51, 97, -66, -28),
                intArrayOf(36, 3, -62, 38, 15, 51, -58, -90, -23, -63),
                intArrayOf(58, -26, -42, -66, 21, 99, -94, -95, -90, 89),
                intArrayOf(83, -66, -42, -45, 43, 85, 51, -86, 65, -39),
                intArrayOf(56, 9, 9, 95, -56, -77, -2, 20, 78, 17),
                intArrayOf(78, -13, -55, 55, -7, 43, -98, -89, 38, 90),
                intArrayOf(32, 44, -47, 81, -1, -55, -5, 16, -81, 17),
                intArrayOf(-87, 82, 2, 86, -88, -58, -91, -79, 44, -9),
                intArrayOf(-96, -14, -52, -8, 12, 38, 84, 77, -51, 52),
            )
        ) shouldBe -879
    }
})

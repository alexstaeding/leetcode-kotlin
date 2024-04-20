import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FindFarmlandTest : FunSpec({
    test("[[1,0,0],[0,1,1],[0,1,1]] = [[0,0,2,2],[1,1,3,3]]") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 1, 1),
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 1, 2, 2),
        )
    }

    test("Empty array should return empty array") {
        findFarmland(
            arrayOf()
        ) shouldBe arrayOf()
    }

    test("Array with only zeros should return empty array") {
        findFarmland(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
            )
        ) shouldBe arrayOf()
    }

    test("Array with only ones should return one farmland") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 2, 2)
        )
    }

    test("Array with multiple separate farmlands should return multiple farmlands") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 0, 1),
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 2, 0, 2),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(2, 2, 2, 2)
        )
    }

    test("Single row should return correct farmlands") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 0, 1, 0, 1)
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 2, 0, 2),
            intArrayOf(0, 4, 0, 4)
        )
    }

    test("Single column should return correct farmlands") {
        findFarmland(
            arrayOf(
                intArrayOf(1),
                intArrayOf(0),
                intArrayOf(1),
                intArrayOf(0),
                intArrayOf(1)
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(4, 0, 4, 0)
        )
    }

    test("Rectangle with more rows than columns should return correct farmlands") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(3, 1, 3, 1)
        )
    }

    test("Rectangle with more columns than rows should return correct farmlands") {
        findFarmland(
            arrayOf(
                intArrayOf(1, 0, 1, 0),
                intArrayOf(0, 1, 0, 1)
            )
        ) shouldBe arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 2, 0, 2),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 3, 1, 3)
        )
    }
})

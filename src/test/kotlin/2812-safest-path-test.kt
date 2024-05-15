import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SafestPathTest : FunSpec({
    test("maximumSafenessFactor([[1,0,0],[0,0,0],[0,0,1]])") {
        maximumSafenessFactor(
            listOf(
                listOf(1, 0, 0),
                listOf(0, 0, 0),
                listOf(0, 0, 1)
            ),
        ) shouldBe 0
    }
    test("maximumSafenessFactor([[0,0,1],[0,0,0],[0,0,0]])") {
        maximumSafenessFactor(
            listOf(
                listOf(0, 0, 1),
                listOf(0, 0, 0),
                listOf(0, 0, 0)
            ),
        ) shouldBe 2
    }
    test("maximumSafenessFactor([[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]])") {
        maximumSafenessFactor(
            listOf(
                listOf(0, 0, 0, 1),
                listOf(0, 0, 0, 0),
                listOf(0, 0, 0, 0),
                listOf(1, 0, 0, 0)
            ),
        ) shouldBe 2
    }
    test("maximumSafenessFactor([[0,1,1],[0,1,1],[0,0,0]])") {
        maximumSafenessFactor(
            listOf(
                listOf(0, 1, 1),
                listOf(0, 1, 1),
                listOf(0, 0, 0)
            ),
        ) shouldBe 1
    }
    test("maximumSafenessFactor([[0,0,1],[0,0,0],[0,0,1]])") {
        maximumSafenessFactor(
            listOf(
                listOf(0, 0, 1),
                listOf(0, 0, 0),
                listOf(0, 0, 1)
            ),
        ) shouldBe 0
    }
    test("maximumSafenessFactor([[0,0,0],[0,1,1],[0,0,0]])") {
        maximumSafenessFactor(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 1, 1),
                listOf(0, 0, 0)
            ),
        ) shouldBe 1
    }
    test("maximumSafenessFactor([[..14x0..1..14x0..]]") {
        val grid = MutableList(29) { MutableList(29) { 0 } }
        grid[14][14] = 1
        maximumSafenessFactor(grid) shouldBe 14
    }
    test("maximumSafenessFactor([[...]]") {
        // [[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,1,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
        val grid = MutableList(14) { MutableList(14) { 0 } }
        grid[6][7] = 1
        grid[7][6] = 1
        grid[7][8] = 1
        maximumSafenessFactor(grid) shouldBe 6
    }
    test("maximumSafenessFactory[[..39x0..]") {
        val grid = MutableList(39) { MutableList(39) { 0 } }
        grid[17][19] = 1
        grid[18][18] = 1
        grid[19][20] = 1
        grid[21][19] = 1
        maximumSafenessFactor(grid) shouldBe 17
    }
})

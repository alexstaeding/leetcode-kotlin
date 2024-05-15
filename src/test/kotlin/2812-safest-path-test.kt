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
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MergeKListsTest : FunSpec({
    test("basics tests") {
        mergeKLists(
            arrayOf(
                listOf(1, 4, 5).toListNodes(),
                listOf(1, 3, 4).toListNodes(),
                listOf(2, 6).toListNodes(),
            )
        ) shouldBe listOf(1, 1, 2, 3, 4, 4, 5, 6).toListNodes()
        mergeKLists(arrayOf()) shouldBe null
        mergeKLists(arrayOf(null)) shouldBe null
    }
})

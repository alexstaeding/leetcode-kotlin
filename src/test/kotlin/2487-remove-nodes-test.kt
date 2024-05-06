import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RemoveNodesTest : FunSpec({
    test("removeNodes([1, 2, 3, 4, 5])") {
        removeNodes(listOf(1, 2, 3, 4, 5).toListNodes()) shouldBe listOf(5).toListNodes()
    }
    test("removeNodes([5, 2, 13, 3, 8])") {
        removeNodes(listOf(5, 2, 13, 3, 8).toListNodes()) shouldBe listOf(13, 8).toListNodes()
    }
    test("removeNodes([1, 1, 1, 1])") {
        removeNodes(listOf(1, 1, 1, 1).toListNodes()) shouldBe listOf(1, 1, 1, 1).toListNodes()
    }
    test("removeNodes([8])") {
        removeNodes(listOf(8).toListNodes()) shouldBe listOf(8).toListNodes()
    }
    test("removeNodes([])") {
        removeNodes(emptyList<Int>().toListNodes()) shouldBe null
    }
})

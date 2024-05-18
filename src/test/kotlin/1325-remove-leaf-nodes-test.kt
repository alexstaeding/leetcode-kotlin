import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RemoveLeafNodesTest : FunSpec({
    test("removeLeafNodes([1,2,3,2,null,2,4], 2)") {
        removeLeafNodes(listOf(1, 2, 3, 2, null, 2, 4).toTree(), 2) shouldBe listOf(1, null, 3, null, 4).toTree()
    }
    test("removeLeafNodes([1,3,3,3,2], 3)") {
        removeLeafNodes(listOf(1, 3, 3, 3, 2).toTree(), 3) shouldBe listOf(1, 3, null, null, 2).toTree()
    }
    test("removeLeafNodes([1,2,null,2,null,2], 2)") {
        removeLeafNodes(listOf(1, 2, null, 2, null, 2).toTree(), 2) shouldBe listOf(1).toTree()
    }
})

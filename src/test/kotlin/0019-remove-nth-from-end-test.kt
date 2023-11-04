import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RemoveNthFromEndTest : FunSpec({
    test("head = [1, 2, 3, 4, 5], n = 2") {
        removeNthFromEnd(listOf(1, 2, 3, 4, 5).toListNodes(), 2) shouldBe listOf(1, 2, 3, 5).toListNodes()
    }
    test("head = [1], n = 1") {
        removeNthFromEnd(listOf(1).toListNodes(), 1) shouldBe listOf<Int>().toListNodes()
    }
    test("head = [1, 2], n = 1") {
        removeNthFromEnd(listOf(1, 2).toListNodes(), 1) shouldBe listOf(1).toListNodes()
    }
    test("head = [1, 2], n = 2") {
        removeNthFromEnd(listOf(1, 2).toListNodes(), 2) shouldBe listOf(2).toListNodes()
    }
})

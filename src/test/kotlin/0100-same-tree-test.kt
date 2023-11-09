import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SameTreeTest : FunSpec({
    test("p = [1, 2, 3], q = [1, 2, 3] -> true") {
        isSameTree(listOf(1, 2, 3).toTree(), listOf(1, 2, 3).toTree()) shouldBe true
    }
    test("p = [1, 2], q = [1, null, 2] -> false") {
        isSameTree(listOf(1, 2).toTree(), listOf(1, null, 2).toTree()) shouldBe false
    }
    test("p = [1,2,1], q = [1,1,2] -> false") {
        isSameTree(listOf(1, 2, 1).toTree(), listOf(1, 1, 2).toTree()) shouldBe false
    }
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class EvaluateTreeTest : FunSpec({
    test("testEvaluateTree([2,1,3,null,null,0,1])") {
        evaluateTree(listOf(2, 1, 3, null, null, 0, 1).toTree()) shouldBe true
    }
    test("testEvaluateTree([0])") {
        evaluateTree(listOf(0).toTree()) shouldBe false
    }
})

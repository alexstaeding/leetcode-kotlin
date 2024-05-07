import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DoubleItTest : FunSpec({
    test("doubleIt([1, 8, 9])") {
        doubleIt(listOf(1, 8, 9).toListNodes()) shouldBe listOf(3, 7, 8).toListNodes()
    }
})

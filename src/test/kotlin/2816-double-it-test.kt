import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DoubleItTest : FunSpec({
    test("doubleIt([1, 8, 9])") {
        doubleIt(listOf(1, 8, 9).toListNodes()) shouldBe listOf(3, 7, 8).toListNodes()
    }
    test("doubleIt([9, 9, 9])") {
        doubleIt(listOf(9, 9, 9).toListNodes()) shouldBe listOf(1, 9, 9, 8).toListNodes()
    }
    test("doubleIt([1])") {
        doubleIt(listOf(1).toListNodes()) shouldBe listOf(2).toListNodes()
    }
    test("doubleIt([])") {
        doubleIt(emptyList<Int>().toListNodes()) shouldBe null
    }
})

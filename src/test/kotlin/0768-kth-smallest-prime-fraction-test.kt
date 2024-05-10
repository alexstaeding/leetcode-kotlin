import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class KthSmallestPrimeFractionTest : FunSpec({
    test("kthSmallestPrimeFraction([1, 2, 3, 5], 3)") {
        kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3) shouldBe intArrayOf(2, 5)
    }
    test("kthSmallestPrimeFraction([1, 7], 1)") {
        kthSmallestPrimeFraction(intArrayOf(1, 7), 1) shouldBe intArrayOf(1, 7)
    }
    test("kthSmallestPrimeFraction([1, 2, 3, 5, 7, 11], 8)") {
        kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5, 7, 11), 8) shouldBe intArrayOf(2, 5)
    }
    test("kthSmallestPrimeFraction([1, 13, 17, 59], 6)") {
        kthSmallestPrimeFraction(intArrayOf(1, 13, 17, 59), 6) shouldBe intArrayOf(13, 17)
    }
})

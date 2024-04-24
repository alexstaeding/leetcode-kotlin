import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TribonacciTest : FunSpec({
    test("tribonacci(0)") {
        tribonacci(0) shouldBe 0
    }

    test("tribonacci(1)") {
        tribonacci(1) shouldBe 1
    }

    test("tribonacci(2)") {
        tribonacci(2) shouldBe 1
    }

    test("tribonacci(4)") {
        tribonacci(4) shouldBe 4
    }

    test("tribonacci(25)") {
        tribonacci(25) shouldBe 1389537
    }

    test("tribonacci(37)") {
        tribonacci(37) shouldBe 2082876103
    }
})

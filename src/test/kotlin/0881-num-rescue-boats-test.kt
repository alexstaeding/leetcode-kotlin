import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RescueBoatsTest : FunSpec({
    test("numRescueBoats([1, 2], 3)") {
        numRescueBoats(intArrayOf(1, 2), 3) shouldBe 1
    }
    test("numRescueBoats([3, 2, 2, 1], 3)") {
        numRescueBoats(intArrayOf(3, 2, 2, 1), 3) shouldBe 3
    }
    test("numRescueBoats([3, 5, 3, 4], 5)") {
        numRescueBoats(intArrayOf(3, 5, 3, 4), 5) shouldBe 4
    }
})

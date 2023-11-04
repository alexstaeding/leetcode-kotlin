import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TrapRainwaterTest : FunSpec({
    test("[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], output = 6") {
        trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) shouldBe 6
    }
    test("[4, 2, 0, 3, 2, 5], output = 9") {
        trap(intArrayOf(4, 2, 0, 3, 2, 5)) shouldBe 9
    }
})

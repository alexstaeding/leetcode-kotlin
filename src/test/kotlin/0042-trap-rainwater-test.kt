import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TrapRainwaterTest : FunSpec({
    test("[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], output = 6") {
        trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) shouldBe 6
    }
    test("[4, 2, 0, 3, 2, 5], output = 9") {
        trap(intArrayOf(4, 2, 0, 3, 2, 5)) shouldBe 9
    }
    test("[6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3],  output = 74") {
        trap(intArrayOf(6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3)) shouldBe 83
    }
})

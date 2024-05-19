import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DistributeCoinsTest : FunSpec({
    test("distributeCoins([0,3,0])") {
        distributeCoins(listOf(0,3,0).toTree()) shouldBe 3
    }
    test("distributeCoins([3,0,0])") {
        distributeCoins(listOf(3,0,0).toTree()) shouldBe 2
    }
})

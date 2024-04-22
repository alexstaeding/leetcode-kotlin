import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OpenLockTest : FunSpec({
    test("openLock([\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"], \"0202\")") {
        openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202") shouldBe 6
    }

    test("openLock([\"8888\"], \"0009\")") {
        openLock(arrayOf("8888"), "0009") shouldBe 1
    }

    test("openLock([\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"], \"8888\")") {
        openLock(arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), "8888") shouldBe -1
    }

    test("openLock[\"0000\"], \"8888\")") {
        openLock(arrayOf("0000"), "8888") shouldBe -1
    }
})

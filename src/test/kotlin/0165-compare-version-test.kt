import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CompareVersionTest : FunSpec({
    test("compareVersion(\"1.0.1\", \"1.001\")") {
        compareVersion("1.01", "1.001") shouldBe 0
    }
    test("compareVersion(\"1.0\", \"1.0.0\")") {
        compareVersion("1.0", "1.0.0") shouldBe 0
    }
    test("compareVersion(\"0.1\", \"1.1\")") {
        compareVersion("0.1", "1.1") shouldBe -1
    }
})

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SearchInsertTest : FunSpec({

    test("[1, 3, 5, 6], 5 == 2") {
        searchInsert(intArrayOf(1, 3, 5, 6), 5) shouldBe 2
    }

    test("[1, 3, 5, 6], 2 == 1") {
        searchInsert(intArrayOf(1, 3, 5, 6), 2) shouldBe 1
    }

    test("[1, 3, 5, 6], 7 == 4") {
        searchInsert(intArrayOf(1, 3, 5, 6), 7) shouldBe 4
    }

    test("[1, 3, 5, 6], 0 == 0") {
        searchInsert(intArrayOf(1, 3, 5, 6), 0) shouldBe 0
    }

    test("[1, 3], 1 == 0") {
        searchInsert(intArrayOf(1, 3), 1) shouldBe 0
    }

    test("[1, 3], 2 == 1") {
        searchInsert(intArrayOf(1, 3), 2) shouldBe 1
    }

    test("[1, 3, 5], 4 == 2") {
        searchInsert(intArrayOf(1, 3, 5), 4) shouldBe 2
    }

    test("[1], 0 == 0") {
        searchInsert(intArrayOf(1), 0) shouldBe 0
    }

    test("[1,2,3,4,5,10], 2 = 1") {
        searchInsert(intArrayOf(1, 2, 3, 4, 5, 10), 2) shouldBe 1
    }

    test("[1,4,6,7,8,9], 6 = 2") {
        searchInsert(intArrayOf(1, 4, 6, 7, 8, 9), 6) shouldBe 2
    }
})

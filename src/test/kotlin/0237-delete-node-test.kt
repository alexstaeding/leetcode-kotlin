import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DeleteNodeTest : FunSpec({
    test("deleteNode([4, 5, 1, 9], 5)") {
        val head = ListNode(4)
        head.next = ListNode(5)
        head.next!!.next = ListNode(1)
        head.next!!.next!!.next = ListNode(9)
        deleteNode(head.next!!)
        head.toString() shouldBe "4, 1, 9"
    }
})

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }

    var slow = head
    var fast = head

    repeat(n) {
        fast = fast!!.next
    }

    if (fast == null) {
        // remove first element
        return head.next
    }

    while (true) {
        fast = fast!!.next
        if (fast == null) {
            break
        }
        slow = slow!!.next
    }
    slow!!.next = slow.next!!.next

    return head
}

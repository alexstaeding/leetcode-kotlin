fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }

    var slow = head
    var fast = head

    var i = 0
    while (i < n) {
        fast = fast?.next
        i++
    }
    if (fast == null) {
        // remove first element
        return head.next
    }

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next
    }
    slow!!.next = slow.next!!.next

    return head
}

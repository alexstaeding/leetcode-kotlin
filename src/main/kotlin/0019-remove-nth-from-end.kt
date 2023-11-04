fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) {
        return null
    }
    val ring = arrayOfNulls<ListNode>(n)
    var ringPos = 0
    var current = head
    while (current != null) {
        ring[ringPos++ % ring.size] = current
        current = current.next
    }

    ring[(ringPos - 1) % ring.size]?.next = ring[ringPos % ring.size]?.next
    return head
}

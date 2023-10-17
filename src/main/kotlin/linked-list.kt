data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun List<Int>.toListNodes(): ListNode? {
    if (isEmpty()) return null
    val head = ListNode(this[0])
    if (size == 1) {
        return head
    }
    var tail = ListNode(this[1])
    head.next = tail
    if (size == 2) {
        return head
    }

    for (item in this.drop(2)) {
        val next = ListNode(item)
        tail.next = next
        tail = next
    }
    return head
}

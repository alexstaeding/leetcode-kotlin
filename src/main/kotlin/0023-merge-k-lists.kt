fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.all { it == null }) return null
    // at least one element is not empty
    var head: ListNode? = null
    var tail: ListNode? = null
    // save position of each sub-list
    val positions = lists.asSequence()
        .filterNotNull()
        .withIndex()
        .associateTo(mutableMapOf()) { it.index to it.value }
    OUTER@ while (true) {
        val listNode = positions.minByOrNull { (_, value) -> value.`val` }
            ?: return head
        if (head == null || tail == null) {
            head = listNode.value
            tail = head
        } else {
            tail.next = listNode.value
            tail = tail.next
        }
        positions.compute(listNode.key) { _, v -> v?.next }
    }
}

import java.util.Comparator
import java.util.PriorityQueue

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.all { it == null }) return null
    // at least one element is not empty
    var head: ListNode? = null
    var tail: ListNode? = null
    // save position of each sub-list
    val positions = lists.filterNotNullTo(PriorityQueue(lists.size * 20, Comparator.comparing(ListNode::`val`)))
    while (true) {
        val listNode = positions.poll()
            ?: return head
        if (head == null || tail == null) {
            head = listNode
            tail = head
        } else {
            tail.next = listNode
            tail = tail.next
        }
        listNode.next?.let { positions.add(it) }
    }
}

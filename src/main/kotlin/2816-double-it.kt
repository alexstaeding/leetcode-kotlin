fun doubleIt(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    doubleItRec(head)
    return if (head.`val` >= 10) {
        head.`val` -= 10
        ListNode(1).also { it.next = head }
    } else {
        head
    }
}


fun doubleItRec(head: ListNode) {
    head.next?.also(::doubleItRec)
    head.`val` *= 2
    head.next?.also { next ->
        if (next.`val` >= 10) {
            next.`val` -= 10
            head.`val`++
        }
    }
}

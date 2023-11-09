import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node(value=$`val`, left=${left?.toString()}, right=${right?.toString()})"
    }
}

fun List<Int?>.toTree(): TreeNode? {
    if (isEmpty()) return null
    val root = TreeNode(this[0] ?: return null)
    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < size) {
        val node = queue.poll()
        if (node != null) {
            if (i < size) {
                this[i]?.let {
                    node.left = TreeNode(it)
                    queue.add(node.left)
                }
            }
            i++
            if (i < size) {
                this[i]?.let {
                    node.right = TreeNode(it)
                    queue.add(node.right)
                }
            }
            i++
        }
    }
    return root
}

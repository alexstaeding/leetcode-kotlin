fun evaluateTree(root: TreeNode?): Boolean {
    if (root == null) {
        return false
    }
    return when (root.`val`) {
        0 -> false
        1 -> true
        2 -> evaluateTree(root.left) || evaluateTree(root.right)
        3 -> evaluateTree(root.left) && evaluateTree(root.right)
        else -> error("Invalid node value ${root.`val`}")
    }
}

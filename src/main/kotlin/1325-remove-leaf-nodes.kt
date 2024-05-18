fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) return null
    root.left = removeLeafNodes(root.left, target)
    root.right = removeLeafNodes(root.right, target)
    return if (root.left == null && root.right == null && root.`val` == target) null else root
}

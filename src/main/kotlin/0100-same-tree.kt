fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if ((p == null) != (q == null)) {
        return false
    }

    if (p?.`val` != q?.`val`) {
        return false
    }

    if (p?.left != null || q?.left != null) {
        if (!isSameTree(p?.left, q?.left)) {
            return false
        }
    }

    if (p?.right != null || q?.right != null) {
        if (!isSameTree(p?.right, q?.right)) {
            return false
        }
    }

    return true
}

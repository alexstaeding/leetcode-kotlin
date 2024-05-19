import kotlin.math.abs

fun distributeCoins(root: TreeNode?): Int = distributeCoinsRec(root).second

private fun distributeCoinsRec(root: TreeNode?): Pair<Int, Int> {
    if (root == null) return 0 to 0

    val (leftBalance, leftMoves) = distributeCoinsRec(root.left)
    val (rightBalance, rightMoves) = distributeCoinsRec(root.right)

    val currentBalance = root.`val` + leftBalance + rightBalance - 1
    val moves = leftMoves + rightMoves + abs(leftBalance) + abs(rightBalance)

    return Pair(currentBalance, moves)
}

import kotlin.math.max

fun trap(height: IntArray): Int {
    var totalWater = 0
    var left = 0
    var right = height.size - 1
    var maxLeft = height[left]
    var maxRight = height[right]
    while (left < right) {
        if (maxLeft < maxRight) {
            left++
            maxLeft = max(maxLeft, height[left])
            totalWater += maxLeft - height[left]
        } else {
            right--
            maxRight = max(maxRight, height[right])
            totalWater += maxRight - height[right]
        }
    }
    return totalWater
}

fun main() {
    println(subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 2))
}

private fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    var low = 0
    var high = 0
    var distinct = 0
    val map = LinkedHashMap<Int, Int>() // num -> count

    var result = 0

    fun inc(num: Int): Int = map.compute(num) { _, v -> (v ?: 0) + 1 }
        ?: throw AssertionError()

    fun dec(num: Int): Int = map.compute(num) { _, v -> v!! - 1 }
        ?: throw AssertionError()

    fun checkInc(num: Int): Int = (map[num] ?: 0) + 1

    while (true) {
        println(
            "[$low, $high] = ${nums.drop(low).take(high - low)} $map :: " +
                "distinct($distinct) result($result)"
        )
        if (distinct > k) {
            if (dec(nums[low++]) == 0) { // completely removed number
                distinct--
            }
            continue
        }
        if (high == nums.size) {
            break
        }
        if (distinct < k) {
            val num = nums[high]
            val count = inc(num)
            if (count == 1) { // only one
                distinct++
            }
            high++
            continue
        }
        result++
        println("Distinct!!")
        if (checkInc(nums[high]) == 1) {
            // check if increasing the window would increase distinct
            // if yes, rather increase low
            if (dec(nums[low++]) == 0) {
                distinct--
            }
            continue
        }
        if (inc(nums[high]) == 1) { // completely removed number
            distinct++
        }
        if (low > nums.size) {
            break
        }
        high++
    }
    return result
}


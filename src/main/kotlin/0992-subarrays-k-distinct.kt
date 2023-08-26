fun main() {
    println(subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 2))
    println(subarraysWithKDistinct(intArrayOf(1, 2, 1, 3, 4), 3))
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
        if (high == nums.size) {
            break
        }
        if (distinct > k) {
            if (dec(nums[low++]) == 0) { // completely removed number
                distinct--
            }
            print("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result) low++ ")
            if (distinct == k) {
                result++
                println("found!")
            } else {
                println()
            }
            continue
        } else if (distinct < k) {
            val num = nums[high]
            val count = inc(num)
            if (count == 1) { // only one
                distinct++
            }
            print("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result) high++ ")
            if (distinct == k) {
                result++
                println("found!")
            } else {
                println()
            }
            high++
            continue
        }
        // if distinct == k
        if (inc(nums[high]) == 1) { // completely removed number
            distinct++
        }
        result++
        println("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result) found! 1")

        if (high + 1 == nums.size) {
            println("End of ze line")
            // we have reached the end of the array
            // it is no longer to increment high

            // increment result until distinct no longer valid
            while (low + k - 1 < high) {
                if (dec(nums[low++]) == 0) {
                    distinct--
                }

                if (distinct == k) {
                    result++
                    println("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result) found! 2")
                } else {
                    println("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result)")
                }
            }

            break
        }

        if (checkInc(nums[high + 1]) == 1) {
            println("Next is bad")
            // the next number would increment the distinct number
            // go back and increment low by one and set high = low + k - 1 (the minimum interval size)
            if (dec(nums[low++]) == 0) {
                distinct--
            }
            while (low + k - 1 < high) {
                if (dec(nums[high--]) == 0) {
                    distinct--
                }
            }

            if (distinct == k) {
                result++
                println("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result) found! 3")
            } else {
                println("[$low, $high] = ${nums.drop(low).take(high - low + 1)} $map :: distinct($distinct) result($result)")
            }

            assert(inc(nums[high + 1]) == 1)

            assert(low + k - 1 == high)
        }
        if (low > nums.size) {
            break
        }
        high++
    }
    return result
}

fun main() {
    val max = 20
    println(calculate(0, max))
}

fun calculate(prefix: Int, max: Int): Int {
    var total = 0
    outer@ for (i in 0..9) {
        // check if i is already in prefix
        var p = prefix
        while (p >= 0) {
            if (p % 10 == i) {
                continue@outer
            }
            p /= 10
            if (p == 0) {
                break
            }
        }
        val newNum = prefix * 10 + i
        if (newNum <= max) {
            total += calculate(newNum, max) + 1
        }
    }
    return total
}

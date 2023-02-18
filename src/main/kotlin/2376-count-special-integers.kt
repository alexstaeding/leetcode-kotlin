fun main() {
    val max = 20
    println(calculate(0, max))
}

fun calculate(prefix: Int, max: Int): Int {
    var total = 0
    for (i in 0..9) {
        if (!prefix.toString().contains(i.toString())) {
            val newNum = prefix * 10 + i
            if (newNum <= max) {
                total += calculate(newNum, max) + 1
            }
        }
    }
    return total
}

fun main() {
    val max = 20
    println(calculate(0, max).count())
}

fun calculate(prefix: Int, max: Int): Sequence<Int> {
    return sequence {
        for (i in 0..9) {
            if (!prefix.toString().contains(i.toString())) {
                val newNum = prefix * 10 + i
                if (newNum <= max) {
                    yield(newNum)
                    yieldAll(calculate(newNum, max))
                }
            }
        }
    }
}

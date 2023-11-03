import java.math.BigInteger

fun factorial(n: Int, downTo: Int = 2): BigInteger {
    var total = BigInteger.ONE
    for (i in n downTo downTo) {
        total = total.multiply(BigInteger.valueOf(i.toLong()))
    }
    return total
}

fun binomCoeff(n: Int, k: Int): BigInteger {
    return if (k > n / 2) {
        factorial(n, k + 1) / factorial(n - k)
    } else {
        factorial(n, (n - k) + 1) / factorial(k)
    }
}

fun climbStairs(n: Int): Int {
    var total = BigInteger.ZERO
    val minSize = (n + 1) / 2
    for ((pick, i) in (n downTo minSize).withIndex()) {
        total += binomCoeff(i, pick)
    }
    return total.toInt()
}

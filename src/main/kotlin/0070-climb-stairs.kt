import java.math.BigInteger

val factorialCache = HashMap<Int, BigInteger>(200)
val binomCache = HashMap<Int, BigInteger>(200)

fun factorial(n: Int, downTo: Int = 2): BigInteger {
    factorialCache[n + (downTo shl 16)]?.let {
        return it
    }
    var total = BigInteger.ONE
    for (i in n downTo downTo) {
        total = total.multiply(BigInteger.valueOf(i.toLong()))
    }
    return total.also { factorialCache[n + (downTo shl 16)] = it }
}

fun binomCoeff(n: Int, k: Int): BigInteger {
    binomCache[n + (k shl 16)]?.let {
        return it
    }
    return if (k > n / 2) {
        factorial(n, k + 1) / factorial(n - k)
    } else {
        factorial(n, (n - k) + 1) / factorial(k)
    }.also { binomCache[n + (k shl 16)] = it }
}

fun climbStairs(n: Int): Int {
    var total = BigInteger.ZERO
    val minSize = (n + 1) / 2
    for ((pick, i) in (n downTo minSize).withIndex()) {
        total += binomCoeff(i, pick)
    }
    return total.toInt()
}

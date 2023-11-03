fun factorial(n: Int): Int {
    var total = 1
    for (i in 2..n) {
        total *= i
    }
    return total
}

fun binomCoeff(n: Int, k: Int): Int =
    factorial(n) / (factorial(k) * factorial(n - k))

fun climbStairs(n: Int): Int {
    var total = 0
    val minSize = (n + 1) / 2
    for ((pick, i) in (n downTo minSize).withIndex()) {
        total += binomCoeff(i, pick)
    }
    return total
}

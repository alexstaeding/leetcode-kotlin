fun tribonacci(n: Int): Int {
    if (n <= 1) {
        return n
    } else if (n == 2) {
        return 1
    }

    var t0 = 0
    var t1 = 1
    var t2 = 1

    for (t in 3..n) {
        val next = t0 + t1 + t2
        t0 = t1
        t1 = t2
        t2 = next
    }

    return t2
}

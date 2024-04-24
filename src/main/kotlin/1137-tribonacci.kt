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

// @formatter:off
val answers = intArrayOf(0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103)
fun tribonacciCheese(n: Int): Int = answers[n]
// @formatter:on

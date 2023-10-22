fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    var x = 0
    var y = 0

    var dX = 1
    var dY = 0

    var mTop = 0
    var mBottom = matrix.size - 1
    var mLeft = 0
    var mRight = matrix[0].size - 1

    val result = mutableListOf<Int>()

    for (i in 0..<matrix.size * matrix[0].size) {
        result.add(matrix[y][x])

        if (x + dX !in mLeft..mRight ||
            y + dY !in mTop..mBottom) {

            // change direction 90 degrees
            // 1, 0 -> 0, 1
            // 0, 1 -> -1, 0
            // -1, 0 -> 0, -1
            // 0, -1 -> 1, 0
            val (oDeltaX, oDeltaY) = dX to dY
            dX = -oDeltaY
            dY = oDeltaX

            // increase boundary at turn
            when {
                dX == 0 && dY == 1 -> mTop++ // heading down
                dX == -1 && dY == 0 -> mRight-- // heading left
                dX == 0 && dY == -1 -> mBottom-- // heading up
                dX == 1 && dY == 0 -> mLeft++ // heading right
            }
        }
        // increment is ok
        x += dX
        y += dY
    }
    return result
}

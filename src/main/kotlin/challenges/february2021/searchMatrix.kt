package challenges.february2021

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.lastIndex
    val n = matrix[0].lastIndex
    var row = 0
    var col = 0

    tailrec fun search(matrix: Array<IntArray>, target: Int, row: Int, col: Int, dy: Int = 0, dx: Int = 1): Boolean {
        if (row > m) {

        }
        if (col > n) {

        }
        val v = matrix[row][col]
        if (v == target) return true
        return if (v > target) {
            search(matrix, target, row, col + 1)
        } else {
            search(matrix, target, row + 1, col - 1)
        }
    }
}


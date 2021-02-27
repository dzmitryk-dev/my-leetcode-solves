package challenges.february2021


/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.lastIndex
    val n = matrix[0].lastIndex
    var row = 0
    var col = n

    while (col >= 0 && row <= m) {
        if (matrix[row][col] == target) return true
        while (col >= 0 && row <= m) {
            val v = matrix[row][col]
            if (v < target) {
                row++
            } else {
                break
            }
        }
        while (col >= 0 && row <= m) {
            val v = matrix[row][col]
            if (v > target) {
                col--
            } else {
                break
            }
        }
    }
    return false
}
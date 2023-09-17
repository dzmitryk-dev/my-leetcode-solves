package general

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    val maxRows = matrix.lastIndex - 1
    val maxIndex = matrix[0].lastIndex - 1
    val indexRange = 0..maxIndex
    for (r in 0..maxRows) {
        val row1 = matrix[r]
        val row2 = matrix[r + 1]
        for (i in indexRange) {
            if (row1[i] != row2[i + 1]) {
                return false
            }
        }
    }
    return true
}
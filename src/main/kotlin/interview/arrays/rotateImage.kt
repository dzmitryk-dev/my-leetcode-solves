package interview.arrays

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/
 */

fun rotate(matrix: Array<IntArray>): Unit {
    for (row in 0..matrix.size/2) {
        for (index in row until matrix.lastIndex - row) {
            val tmp = matrix[row][index]
            matrix[row][index] = matrix[matrix.lastIndex - index][row]
            matrix[matrix.lastIndex - index][row] = matrix[matrix.lastIndex - row][matrix.lastIndex - index]
            matrix[matrix.lastIndex - row][matrix.lastIndex - index] = matrix[index][matrix.lastIndex - row]
            matrix[index][matrix.lastIndex - row] = tmp
        }
    }
}
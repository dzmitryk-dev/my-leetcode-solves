import java.util.BitSet

/*
    https://leetcode.com/problems/gray-code/
 */
// Fucking magic
fun grayCode(n: Int): List<Int> {
    return (0 until(1 shl n)).map {
        it xor (it shr 1)
    }
}

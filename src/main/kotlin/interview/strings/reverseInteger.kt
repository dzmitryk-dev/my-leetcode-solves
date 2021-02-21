package interview.strings

import kotlin.math.abs
import kotlin.math.sign

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/
 */
fun reverse(x: Int): Int {
    if (x == 0) return x
    val sign = x.sign
    var newValue = 0
    var value = abs(x)
    while (value > 0) {
        val x = value % 10
        try {
            newValue = Math.addExact(Math.multiplyExact(newValue, 10), x)
        } catch (ex: ArithmeticException) {
            return 0
        }
        value /= 10
    }
    return newValue * sign
}
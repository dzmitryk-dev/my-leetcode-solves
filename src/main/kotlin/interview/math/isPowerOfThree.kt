package interview.math

/*
    https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/745/
 */

fun isPowerOfThree(n: Int): Boolean {
    if (n == 0) return false
    if (n == 1) return true
    if (n % 3 > 0) return false
    var k = n
    do {
        k /= 3
    } while(k > 1 && k % 3 == 0)
    return k == 1
}
package general

/**
 * https://leetcode.com/problems/palindrome-number
 */
fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    if (x == 0) return true
    if (x % 10 == 0) return false
    val reversedX = reverse(x)
    return x == reversedX
}

private tailrec fun reverse(value: Int, newValue: Int = 0): Int {
    return if (value == 0) newValue
    else reverse(value / 10, (newValue * 10 + value % 10))
}
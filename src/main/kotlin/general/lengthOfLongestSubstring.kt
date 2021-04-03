/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

fun lengthOfLongestSubstring(s: String): Int {
    if (s.length == 1) return 1
    val charIndexes = mutableMapOf<Char, Int>()
    var maxSize = 0
    var startIndex = 0
    for ((index, c) in s.withIndex()) {
        if (charIndexes.contains(c)) {
            val charIndex = charIndexes[c]!!
            if (charIndex >= startIndex) {
                if (index - startIndex > maxSize) {
                    maxSize = index - startIndex
                }
                startIndex = charIndex + 1
            }
        }
        charIndexes[c] = index
    }
    if (s.lastIndex - startIndex + 1> maxSize) {
        maxSize = s.lastIndex - startIndex + 1
    }
    return maxSize
}
/**
 * https://leetcode.com/problems/decode-ways/
 */

private val cache = mutableMapOf<String, Int>()

fun numDecodings(s: String): Int {
    if (s.isEmpty()) return 0
    val case1 = s.take(1)
    if (case1 == "0") return 0
    val cached = cache[s]
    if (cached != null) {
        return cached
    }
    val branch1 = if (s.length > 1) {
        numDecodings(s.substring(1))
    } else {
        1
    }
    val branch2 = if (s.length > 1) {
        val case2 = s.take(2)
        if (case2.toInt() > 26) return branch1
        if (s.length > 2) {
            numDecodings(s.substring(2))
        } else {
            1
        }
    } else {
        0
    }
    return (branch1 + branch2).also {
        cache[s] = it
    }
}
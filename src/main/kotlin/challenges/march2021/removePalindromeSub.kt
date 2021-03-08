package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3665/
 */

// WTF? Oo
fun removePalindromeSub(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.reversed() == s) return 1
    return if (s.contains("b") && s.contains("a")) {
        2
    } else {
        1
    }
}
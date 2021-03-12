package challenges.march2021

import pow2

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/
 */
fun hasAllCodes(s: String, k: Int): Boolean {
    if (s.length <= k) return false
    val unicStrings = mutableSetOf<String>()
    for (index in 0..s.length - k) {
        unicStrings.add(s.substring(index, index + k))
    }
    return unicStrings.size == pow2(k)
}
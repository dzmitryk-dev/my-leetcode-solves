package challenges.february2021

import java.util.*

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3649/
 */

fun findLongestWord(s: String, d: List<String>): String {
    val sortedDict = d.sortedWith(object : Comparator<String> {
        override fun compare(s0: String, s1: String): Int {
            val v = s1.length - s0.length
            return if (v != 0) {
                v
            } else {
                s0.compareTo(s1)
            }
        }
    })
    for (word in sortedDict) {
        if (word.length > s.length) {
            continue
        }
        val wordIterator = word.iterator()
        val stringIterator = s.iterator()
        var contains = false
        while (wordIterator.hasNext() && stringIterator.hasNext()) {
            val character1 = wordIterator.nextChar()
            do {
                val character2 = stringIterator.nextChar()
                contains = (character1 == character2)
            } while (character1 != character2 && stringIterator.hasNext())
        }
        if (!wordIterator.hasNext() && contains) {
            return word
        }
    }
    return ""
}
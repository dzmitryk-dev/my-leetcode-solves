package challenges.march2021

import java.lang.StringBuilder

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/
 */
fun minimumLengthEncoding(words: Array<String>): Int {
    words.sortByDescending {  it.length }
    val builder = StringBuilder()
    words.fold(builder) { acc, s ->
        if (acc.contains("$s#")) {
            acc
        } else {
            acc.append(s).append('#')
        }
    }
    return builder.length
}
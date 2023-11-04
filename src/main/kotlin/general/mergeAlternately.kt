package general

import kotlin.math.min

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
fun mergeAlternately(word1: String, word2: String): String {
    return buildString {
        val iterations = min(word1.length, word2.length)

        repeat(iterations) { index ->
            append(word1[index])
            append(word2[index])
        }

        if (word1.length > iterations) {
            append(word1.substring(iterations))
        } else if (word2.length > iterations) {
            append(word2.substring(iterations))
        }
    }
}
package general

/*
    https://leetcode.com/problems/longest-common-prefix/submissions/
 */

fun longestCommonPrefix(strs: Array<String>): String {
    val possibleLenght = strs.map { it.length }
        .min() ?: 0

    var index = 0
    while (index < possibleLenght) {
        val symbol = strs.first()[index]
        val result = strs.all { it[index] == symbol }
        if (result) {
            index++
        } else {
            break
        }
    }

    return if (index > 0) {
        strs.first().substring(0, index)
    } else {
        ""
    }
}
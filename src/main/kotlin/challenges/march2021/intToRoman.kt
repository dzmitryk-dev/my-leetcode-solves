package challenges.march2021

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/
 */
fun intToRoman(num: Int): String {
    var rest = num
    val stringBuilder = StringBuilder()
    for (i in romanValues.lastIndex downTo 0) {
        val romanValue = romanValues[i]
        val result = rest / romanValue
        rest %= romanValue
        if (result > 0) {
            stringBuilder.append(map(romanValue).repeat(result))
        }
    }
    return stringBuilder.toString()
}

private val romanValues = intArrayOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)

private fun map(value: Int): String {
    return when(value) {
        1 -> "I"
        4 -> "IV"
        5 -> "V"
        9 -> "IX"
        10 -> "X"
        40 -> "XL"
        50 -> "L"
        90 -> "XC"
        100 -> "C"
        400 -> "CD"
        500 -> "D"
        900 -> "CM"
        1000 -> "M"
        else -> throw IllegalArgumentException("There is no such ROMAN number")
    }
}